import lml.servive.IaccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    @Test
    public void account(){
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("bean.xml");
        IaccountService accountService = (IaccountService) ca.getBean("accountService");
        accountService.saveAccount();
    }
}
