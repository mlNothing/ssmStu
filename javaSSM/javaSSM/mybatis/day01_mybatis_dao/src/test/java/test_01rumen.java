import damain.user;
import dao.IuserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class test_01rumen {
    private IuserDao iuserDao=null;
    private InputStream is=null;
    private SqlSession sqlSession=null;
@Before
    public void init()
    {
        //1.读取配置
        is = Resources.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
        //2.创建SqlSessionFactory工厂  mybatis使用了构建者模式（类似工厂）
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
         sqlSession = factory.openSession();
        iuserDao = sqlSession.getMapper(IuserDao.class);

    }
@After
    public void destory() throws IOException {
        is.close();
    }
@Test
public void findAll() throws IOException {
        //5.使用代理对象执行方法
        List<user> users = iuserDao.FindAll();
        for (user key : users) {
            System.out.println(key);
        }

    }
@Test
public void saveUser() throws IOException {
    user user = new user();
    user.setUsername("chaofan");
    user.setBirthday(new Date());
    user.setAddress("北京");
    user.setSex("男");
    //5.使用代理对象执行方法
    iuserDao.saveUser(user);
    System.out.println(user);
}

    @Test
    public void uptateUser() throws IOException {
       user user = new user();
        user.setId(59);
        user.setUsername("玲000");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("男");
        //5.使用代理对象执行方法
        iuserDao.updateUser(user);
    }

    @Test
    public void deleteIdUser() throws IOException {

        iuserDao.deleteIdUser(43);

    }

    @Test
    public void FindIdUser() throws IOException {

        user idUser = iuserDao.findIdUser(41);
        System.out.println(idUser);
    }
    @Test
    public void FindNameUser() throws IOException {

        List<user> users = iuserDao.findNameUser("%王%");
        for (user one : users) {

            System.out.println(one);
        }
    }
    @Test
    public void findTotal()
    {
        user user=new user();
        int total = iuserDao.findTotal(user);
        System.out.println(total);
    }
}
