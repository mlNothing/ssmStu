package service;

import dao.IaccountDao;
import org.springframework.stereotype.Component;
import pojo.account;
import utils.transactionManager;

import java.sql.SQLException;
import java.util.List;

@Component("accountService")
public class IaccountServiceImpl implements IaccountService
{
    private IaccountDao accDao;
    private transactionManager ts;

    public void setTs(transactionManager ts) {
        this.ts = ts;
    }

    public void setAccDao(IaccountDao accDao) {
        this.accDao = accDao;
    }

    public List<account> findAll() throws SQLException {
        List<account> accounts=null;
        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
            accounts= accDao.findAll();
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();

        }finally {
//            释放
            ts.close();
        }
        return accounts;
    }

    public account findById(Integer id) throws SQLException {

        account accounts=null;
        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
            accounts= accDao.findById(id);
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();
            throw new RuntimeException(E);
        }finally {
//            释放
            ts.close();
        }
        return accounts;

    }

    public void updateAcc(account acc) throws SQLException {
        List<account> accounts=null;
        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
          accDao.updateAcc(acc);
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();
            throw new RuntimeException(E);
        }finally {
//            释放
            ts.close();
        }

    }

    public void deleteById(Integer id) throws SQLException {

        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
           accDao.deleteById(id);
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();
            throw new RuntimeException(E);
        }finally {
//            释放
            ts.close();
        }

    }

    public void insert(account acc) throws SQLException {

        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
            accDao.insert(acc);
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();
            throw new RuntimeException(E);
        }finally {
//            释放
            ts.close();
        }

    }
    //模拟转账操作
    public void transfer(String sourceName , String targetName ,float money) throws SQLException {

        try {
            //开启事务
            ts.beginTransaction();
            //执行操作
            //获取转账人的钱数
            account aa = accDao.findByNme(sourceName);
            account bb = accDao.findByNme(targetName);
            //转账
            aa.setMoney(aa.getMoney()-money);
            bb.setMoney(bb.getMoney()+money);
            //更新
            accDao.updateAcc(aa);
            //int a=1/0;
            accDao.updateAcc(bb);
            //提交事务
            ts.commit();
            //返回结果

        }catch (Exception E){
            //回滚
            ts.rollback();
            throw new RuntimeException(E);
        }finally {
//            释放
            ts.close();
        }

    }
}
