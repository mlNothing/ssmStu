import config.SpringConfigu;
import lml.pojo.account;
import lml.service.IaccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfigu.class)
public class testCURD2 {
    IaccountService accountService=null;
    @Test
    public void findAll()
    {
        try {
            List<account> all = accountService.findAll();
            System.out.println(all);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
