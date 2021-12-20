package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;
import pojo.account;

import java.sql.SQLException;
import java.util.List;

public class IaccountDaoImpl implements  IaccountDao{

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<account> findAll() throws SQLException {
        return  runner.query("select *from account",new BeanListHandler<account>(account.class));
    }

    public account findById(Integer id) throws SQLException {
        return runner.query("select *from account where id=?",new BeanHandler<account>(account.class),id);
    }

    public void updateAcc(account acc) throws SQLException {
        runner.update("update account set name=?,money=? where id=?",acc.getName(),acc.getMoney(),acc.getId());
    }

    public void deleteById(Integer id) throws SQLException {
        runner.update("delete *from account where id =?",new BeanHandler<account>(account.class),id);
    }

    public void insert(account acc) throws SQLException {
        runner.update("insert into account values(?,?)",acc.getName(),acc.getMoney());
    }


}
