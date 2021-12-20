import damain.user;
import dao.IuserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test01rumen {
    /**
     * 入门案例
     */
    public static void main(String[] args) throws IOException {
        //1.获取配置
             InputStream is= Resources.class.getResourceAsStream("/X1sqlMybatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(is);
        //3.通过factory生产对象
        SqlSession sqlSession = factory.openSession();
        //4.使用sqlsession创建dao接口代理对象，加强功能
        IuserDao user = sqlSession.getMapper(IuserDao.class);
        //5.使用代理对象执行方法
        List<user> users = user.FindAll();
        for (user key : users) {

            System.out.println(key);
        }
        //6.关闭资源
        sqlSession.close();
        is.close();

    }
}
