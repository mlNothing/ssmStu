import lml.config.SpringConfigu;
import lml.service.IaccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfigu.class)
public class Spring_curd1 {
    @Autowired
   private IaccountService as;
    @Test
    public void findAll() throws SQLException {

        as.transfer("aa","bb",100);
    }


}
