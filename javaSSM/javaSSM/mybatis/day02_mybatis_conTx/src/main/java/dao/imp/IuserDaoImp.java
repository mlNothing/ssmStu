package dao.imp;
import damain.user;
import dao.IuserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

public class IuserDaoImp implements IuserDao {
    private SqlSessionFactory factory;
    public  IuserDaoImp(SqlSessionFactory factory)
    {
        this.factory=factory;
    }
    @Override
    public List<user> FindAll() {
        //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
        List<user> list = sqlSession.selectList("dao.IuserDao.FindAll");
        //释放资源
        sqlSession.close();
        return list;
    }

    @Override
    public void saveUser(user user) {
        //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
         sqlSession.insert("dao.IuserDao.saveUser", user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return;
    }

    @Override
    public void updateUser(user user) {
    //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
        sqlSession.update("dao.IuserDao.updateUser", user);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return;
    }

    @Override
    public void deleteIdUser(Integer uid) {
        //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
        sqlSession.delete("dao.IuserDao.deleteIdUser",uid);
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return;
    }

    @Override
    public user findIdUser(Integer uid)
    {
        //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
        user user = sqlSession.selectOne("dao.IuserDao.findIdUser", uid);
        //释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public List<user> findNameUser(String name) {

        //根据factory获取SqlFactory对象
        SqlSession sqlSession = factory.openSession();
        //调用sqlSession中的查询方法
        List<user> list = sqlSession.selectList("dao.IuserDao.findNameUser", name);
        //释放资源
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @Override
    public int findTotal(user user) {
        SqlSession sqlSession = factory.openSession();
        Integer o = sqlSession.selectOne("dao.IuserDao.findTotal", user);
        return o;
    }
}
