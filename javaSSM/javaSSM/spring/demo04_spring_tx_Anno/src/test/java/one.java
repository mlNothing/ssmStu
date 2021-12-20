import lml.config.SpringConfigu;
import lml.service.IaccountService;
import lml.service.IaccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigu.class)
public class one {
    @Autowired
    private IaccountService a;
    @Test
    public void one() throws SQLException {

        a.transfer("aa","bb",100f);
    }
}
