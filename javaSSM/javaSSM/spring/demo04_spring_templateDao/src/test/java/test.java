import dao.IaccountDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.account;

public class test {
    @Test
    public void one(){
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext("bean.xml");
        IaccountDao accountDao = co.getBean("accountDao", IaccountDao.class);
        account a = accountDao.findById(1);
        System.out.println(a);

    }
}
