import dao.IroleDao;
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

public class role {
    private IroleDao iroleDao =null;
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
        //3.通过factory生产对象
         sqlSession = factory.openSession();
        //4.使用sqlsession创建dao接口代理对象，加强功能
        iroleDao= sqlSession.getMapper(IroleDao.class);
    }
@After
    public void destory() throws IOException {
        //6.关闭资源
        sqlSession.close();
        is.close();
    }
    /**
     *使用account来查找所有
     */
    @Test
public void findAll() throws IOException {
        //5.使用代理对象执行方法

        List<damain.role> keys = iroleDao.FindAll();
        for (damain.role key : keys) {
            System.out.println("----");
            System.out.println(key);
        }

    }
    @Test
    public void FindAllUser() throws IOException{
        List<damain.role> roles= iroleDao.FindAllUser();
        for (damain.role role: roles) {
            System.out.println("---------");
            System.out.println(role);
            System.out.println(role.getUser());
        }
    }

}
