package lml.dao;

import lml.config.AccountRowMapper;
import lml.pojo.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
@Component("accDao")
public class IaccountDaoImpl  implements IaccountDao {
    @Autowired
    private JdbcTemplate template;

    public List<account> findAll() {
        List<account> one= template.query("select *from account",new AccountRowMapper());
        return one;
    }

    public account findById(Integer id) {
        List<account> account = template.query("select *from account where id = ?", new AccountRowMapper(), id);

        return account.isEmpty()?null:account.get(0);
    }
    public account findByNme(String name){
        List<account> account = template.query("select *from account where name = ?", new AccountRowMapper(), name);
        if (account.isEmpty()){
            return null;
        }
        if (account.size()>1){
            throw new RuntimeException("结果集不唯一。");
        }
        return account.get(0);
    }

    public void insert(account account) {

        template.update("insert  into account values(NULL ,?,?)",account.getName(),account.getMoney());
    }

    public void deleteById(Integer id) {
        template.update("delete from account whew id = ?",id);
    }

    public void updateAcc(account account) {
        template.update("update account set name =? ,money =? where id =? ",account.getName(),account.getMoney(),account.getId());
    }
}
