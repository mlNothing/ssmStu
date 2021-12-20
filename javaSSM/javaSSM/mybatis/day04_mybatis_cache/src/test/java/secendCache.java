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

public class secendCache {
    private IuserDao iuserDao =null;
    private InputStream is=null;
    private SqlSessionFactory factory=null;
    @Before
    public void init()
    {
        is = Resources.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
        //2.创建SqlSessionFactory工厂  mybatis使用了构建者模式（类似工厂）
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
    }
@After
    public void destory() throws IOException {

        is.close();
    }

    /**
     * 判断er级缓存是否存在
     * @throws IOException
     */
    @Test
    public void Cache() throws IOException{
        SqlSession sqlSession = factory.openSession();
        IuserDao iuserDao = sqlSession.getMapper(IuserDao.class);
        user user = iuserDao.FindById(41);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession1 = factory.openSession();
        IuserDao iuserDao1= sqlSession1.getMapper(IuserDao.class);
        damain.user user1 = iuserDao1.FindById(41);
        System.out.println(user1);
        sqlSession1.close();
        System.out.println(user==user1);

    }



}
