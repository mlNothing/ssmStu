package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pojo.account;

import java.util.List;

@Component("accountDao")
public class IaccountDaoImpl  implements IaccountDao{
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<account> findAll() {
        List<account> one= template.query("select *from account",new AccountRowMapper());
        return one;
    }

    public account findById(Integer id) {
        List<account> account = template.query("select *from account where id = ?", new AccountRowMapper(), id);

        return account.isEmpty()?null:account.get(0);
    }
    public account findByName(String name){
        List<account> account = template.query("select *from account where name = ?", new AccountRowMapper(), name);
            if (account.isEmpty()){
                return null;
            }
            if (account.size()>1){
                throw new RuntimeException("结果集不唯一。");
            }
        return account.get(0);
    }

    public void insertAcc(account account) {

            template.update("insert  into account values(NULL ,?,?)",account.getName(),account.getMoney());
    }

    public void deleteAcc(Integer id) {
            template.update("delete from account whew id = ?",id);
    }

    public void updateAcc(account account) {
        template.update("update account set name =? ,money =? where id =? ",account.getName(),account.getMoney(),account.getId());
    }
}
