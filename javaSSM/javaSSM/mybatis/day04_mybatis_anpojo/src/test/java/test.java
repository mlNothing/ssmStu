import damain.user;
import dao.IuserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class test {
   private InputStream is=null;
   private IuserDao iuserDao =null;
   private SqlSessionFactoryBuilder builder=null;
   private SqlSessionFactory factory=null;
    private SqlSession sqlSession=null;
    @Before
    public void init()
    {
        is= Resource.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
         builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
        sqlSession = factory.openSession();
        iuserDao = sqlSession.getMapper(IuserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        is.close();

    }
    @Test
    public void Findall()
    {
        List<user> findall = iuserDao.Findall();
        for (user user : findall) {
            System.out.println("-------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void FindById()
    {

        user user = iuserDao.FindById(41);
        System.out.println(user);
    }
   @Test
    public void update()
    {
        user user = new user();
        user.setUserId(54);
        user.setUserName("好了");
        iuserDao.updateById(user);
        sqlSession.commit();//不要忘记啊
        List<damain.user> findall = iuserDao.Findall();
        for (damain.user user1 : findall) {
            System.out.println(user1);
        }
    }
       @Test
      public void saveUser()
      {
          user user = new user();
          user.setUserName("张无");
          user.setUserSex("女");
          user.setUserAddress("南京");
          user.setUserBirthday(new Date());
          iuserDao.saveUser(user);
          sqlSession.commit();

      }
  @Test
      public  void delete()
      {
          user user = new user();
          user.setUserId(61);
          iuserDao.deleteById(user);
          sqlSession.commit();
      }
@Test
    public void findUsername()
    {
        List<user> username = iuserDao.findUsername("%吕%");
        for (user user : username) {
            System.out.println(user);
        }
    }

    @Test
    public void findUn()
    {
        List<user> username = iuserDao.findUn("吕");
        for (user user : username) {
            System.out.println(user);
        }
    }
    @Test
    public void selectTotal()
    {
        Integer i = iuserDao.selectTotal();
        System.out.println(i);
    }
}
