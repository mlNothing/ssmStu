import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.account;
import service.IaccountService;

import java.sql.SQLException;
import java.util.List;

public class Spring_curd1 {
    @Test
    public void findAll() throws SQLException {
       ApplicationContext cc = new ClassPathXmlApplicationContext("bean.xml");
        IaccountService accountService = cc.getBean("accountService", IaccountService.class);
        List<account> all = accountService.findAll();
        System.out.println(all);
    }
    @Test
    public void findById() throws SQLException {
        ApplicationContext cc = new ClassPathXmlApplicationContext("bean.xml");
        IaccountService accountService = cc.getBean("accountService", IaccountService.class);
        account all =  accountService.findById(1);
        System.out.println(all);
    }
    @Test
    public void update(){}
    @Test
    public void deleteById(){}
    @Test
    public void insert(){}

}
