import config.SpringConfigu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import lml.pojo.account;
import lml.service.IaccountService;

import java.sql.SQLException;
import java.util.List;

public class testCURD {
    @Test
    public void findAll()
    {
       ApplicationContext cp =  new AnnotationConfigApplicationContext(SpringConfigu.class);
        IaccountService accountService = cp.getBean("accountService", IaccountService.class);
       
        try {
            List<account> all = accountService.findAll();
            System.out.println(all);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
