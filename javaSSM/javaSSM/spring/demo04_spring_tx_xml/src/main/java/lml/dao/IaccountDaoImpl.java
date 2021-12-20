package lml.dao;

import lml.config.AccountRowMapper;
import lml.config.jdbcDaoSupport;
import lml.pojo.account;


import java.sql.SQLException;
import java.util.List;

public class IaccountDaoImpl extends jdbcDaoSupport implements IaccountDao {
    public List<account> findAll() {
        List<account> one= getJdbcTemplate().query("select *from account",new AccountRowMapper());
        return one;
    }

    public account findById(Integer id) {
        List<account> account = getJdbcTemplate().query("select *from account where id = ?", new AccountRowMapper(), id);

        return account.isEmpty()?null:account.get(0);
    }
    public account findByNme(String name){
        List<account> account = getJdbcTemplate().query("select *from account where name = ?", new AccountRowMapper(), name);
        if (account.isEmpty()){
            return null;
        }
        if (account.size()>1){
            throw new RuntimeException("结果集不唯一。");
        }
        return account.get(0);
    }

    public void insert(account account) {

        getJdbcTemplate().update("insert  into account values(NULL ,?,?)",account.getName(),account.getMoney());
    }

    public void deleteById(Integer id) {
        getJdbcTemplate().update("delete from account whew id = ?",id);
    }

    public void updateAcc(account account) {
        getJdbcTemplate().update("update account set name =? ,money =? where id =? ",account.getName(),account.getMoney(),account.getId());
    }


    protected void checkDaoConfig() throws IllegalArgumentException {

    }
}
