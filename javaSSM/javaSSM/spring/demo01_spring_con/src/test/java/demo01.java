import dao.Iaccount;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IaccountSer;

public class demo01 {
   @Test
    public void test()
    {
        //使用ApplicationContext接口，就是再获取spring容器
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        //根据bean的id获取对象
        IaccountSer aService= (IaccountSer) cp.getBean("accountService");
        System.out.println(aService);

    }

}
