package lml.service;

import lml.dao.IaccountDao;
import lml.pojo.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Component("accountService")
@Transactional(readOnly=true,propagation= Propagation.SUPPORTS)
public class IaccountServiceImpl implements IaccountService
{
    @Autowired
    private IaccountDao accDao;

    public void setAccDao(IaccountDao accDao) {
        this.accDao = accDao;
    }

    public List<account> findAll() throws SQLException {
        return accDao.findAll();
    }

    public account findById(Integer id) throws SQLException {
        return accDao.findById(id);
    }

    public void updateAcc(account acc) throws SQLException {
        accDao.updateAcc(acc);
    }

    public void deleteById(Integer id) throws SQLException {
        accDao.deleteById(id);
    }

    public void insert(account acc) throws SQLException {
        accDao.insert(acc);
    }
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void transfer(String sourceName, String targetName, float money) throws SQLException {
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
    }


}
