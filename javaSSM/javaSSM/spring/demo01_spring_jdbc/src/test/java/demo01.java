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
        IaccountSer aService= (IaccountSer) cp.getBean("IaccountSer");
        System.out.println(aService);

        Iaccount ac= (Iaccount) cp.getBean("Iaccount");
        System.out.println(ac);
    }

    /**
     * 第二种：spring管理静态工厂，-使用静态工厂的方法创建对象
     * * 模拟一个静态工厂，创建业务层实现类*
     */
    @Test
    public void test1()
    {
        //使用ApplicationContext接口，就是再获取spring容器
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        //根据bean的id获取对象
        IaccountSer aService= (IaccountSer) cp.getBean("accountServive");
        System.out.println(aService);
        /*service.imp.IaccountSerImp@6d4d66d2
dao.imp.IaccountImp@2a265ea9*/
        Iaccount ac= (Iaccount) cp.getBean("Iaccount");
        System.out.println(ac);
    }
    @Test
    public void test3()
    {
        //使用ApplicationContext接口，就是再获取spring容器
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        //根据bean的id获取对象
        IaccountSer aService= (IaccountSer) cp.getBean("accountService");
        System.out.println(aService);
            /*service.imp.IaccountSerImp@6d4d66d2
            dao.imp.IaccountImp@2a265ea9*/
        Iaccount ac= (Iaccount) cp.getBean("Iaccount");
        System.out.println(ac);
    }
}
