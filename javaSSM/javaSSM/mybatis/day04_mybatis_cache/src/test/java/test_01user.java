import damain.user;
import dao.IuserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test_01user {
    private IuserDao iuserDao =null;
    private InputStream is=null;
    private SqlSession sqlSession=null;
    private SqlSessionFactory factory=null;
    @Before
    public void init()
    {
        //1.读取配置
        is = Resources.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
        //2.创建SqlSessionFactory工厂  mybatis使用了构建者模式（类似工厂）
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      factory = builder.build(is);
        //3.通过factory生产对象
         sqlSession = factory.openSession();
        //4.使用sqlsession创建dao接口代理对象，加强功能
        iuserDao= sqlSession.getMapper(IuserDao.class);
    }
@After
    public void destory() throws IOException {
        //6.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 判断一级缓存是否存在
     * @throws IOException
     */
    @Test
    public void OneLevelCache() throws IOException{
      user users = iuserDao.FindById(41);
        System.out.println(users);
        user  users1 = iuserDao.FindById(41);
        System.out.println(users1);
        System.out.println(users1==users);
        //true
    }

    /**
     * 把一级缓存关掉后，看看什么情况
     * @throws IOException
     */
    @Test
    public void OneLevelCache1() throws IOException{
        user users = iuserDao.FindById(41);
        System.out.println(users);
     /*   sqlSession.close();//关掉建造的对象
        sqlSession = factory.openSession();//重新打开
       */
        sqlSession.clearCache();//清除掉缓存
        iuserDao= sqlSession.getMapper(IuserDao.class);
        user users1 = iuserDao.FindById(41);
        System.out.println(users1);
        System.out.println(users1==users);//false 与上面不一样

    }

    /**
     * 更行后数据如何查找
     * @throws IOException
     */
    @Test
    public void uptateCache1() throws IOException{
        user  user1 = iuserDao.FindById(41);
        user1.setUsername("张三");
        user1.setAddress("南京");
        iuserDao.updateById(user1);
        System.out.println(user1);
        user  users1 = iuserDao.FindById(41);
        System.out.println(users1==user1);//false 与上面不一样

    }

}
