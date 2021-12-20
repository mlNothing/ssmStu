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
        accountService.transfer("aa","bb",100);
    }

}
