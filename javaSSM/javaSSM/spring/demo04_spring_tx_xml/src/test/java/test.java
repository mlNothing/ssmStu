
import lml.service.IaccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class test {
    @Test
    public void one() throws SQLException {
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext("bean.xml");
        IaccountServiceImpl a = co.getBean("accountService",IaccountServiceImpl.class);
        a.transfer("aa","bb",100f);
    }
}
