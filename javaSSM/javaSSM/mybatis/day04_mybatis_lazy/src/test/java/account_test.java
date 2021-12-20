import damain.account;
import damain.user;
import dao.IaccountDao;

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

public class account_test {
    private IaccountDao iaccountDao = null;
    private InputStream is = null;
    private SqlSession sqlSession = null;

    @Before
    public void init() {
        //1.读取配置
        is = Resources.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
        //2.创建SqlSessionFactory工厂  mybatis使用了构建者模式（类似工厂）
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.通过factory生产对象
        sqlSession = factory.openSession();
        //4.使用sqlsession创建dao接口代理对象，加强功能
        iaccountDao = sqlSession.getMapper(IaccountDao.class);
    }

    @After
    public void destory() throws IOException {
        //6.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 使用account来查找所有
     */
    @Test
    public void findAll() throws IOException {
        //5.使用代理对象执行方法
        List<damain.account> accounts = iaccountDao.FindAll();
        for (damain.account key : accounts) {
            System.out.println("-------");
            System.out.println(key);
            System.out.println(key.getUser());
        }

    }
}
