import damain.account;
import damain.user;
import dao.IaccountDao;
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

public class testaccunt {
   private InputStream is=null;
   private IaccountDao iaccountDao =null;
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
        iaccountDao = sqlSession.getMapper(IaccountDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        is.close();

    }
    @Test
    public void Findacc()
    {
        List<account> findacc = iaccountDao.Findacc();
        for (account account : findacc) {
            System.out.println("---------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void FindByAId()
    {

        account accountr = iaccountDao.FindByAId(1);
        System.out.println(accountr);
    }
}
