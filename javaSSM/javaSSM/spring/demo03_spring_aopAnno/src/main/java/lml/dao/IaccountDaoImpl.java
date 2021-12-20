package lml.dao;

import lml.config.connectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lml.pojo.account;

import java.sql.SQLException;
import java.util.List;
@Component("accDao")
public class IaccountDaoImpl implements IaccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private connectionUtils connectionUtils;



    public List<account> findAll() throws SQLException {

        List<account> query = runner.query(connectionUtils.getThreadConnection(),"select *from account", new BeanListHandler<account>(account.class));
        System.out.println(query);

        return  query;
    }

    public account findById(Integer id) throws SQLException {
        return runner.query(connectionUtils.getThreadConnection(),"select *from account where id=?",new BeanHandler<account>(account.class),id);
    }

    public void updateAcc(account acc) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",acc.getName(),acc.getMoney(),acc.getId());
    }

    public void deleteById(Integer id) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"delete *from account where id =?",new BeanHandler<account>(account.class),id);
    }

    public void insert(account acc) throws SQLException {
        runner.update(connectionUtils.getThreadConnection(),"insert into account values(?,?)",acc.getName(),acc.getMoney());
    }

    public account findByNme(String name) throws SQLException {
        List<account> accounts= runner.query(connectionUtils.getThreadConnection(),"select *from account where name=?",new BeanListHandler<account>(account.class),name);
        if (accounts.size()==0||accounts==null)
        {
            return null;
        }if (accounts.size()>1)
        {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }



}
