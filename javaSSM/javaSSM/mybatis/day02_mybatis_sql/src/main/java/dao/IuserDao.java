package dao;

import damain.QueryTo;
import damain.user;

import java.util.List;

public interface IuserDao{
    /**
     * 查找所有的用户
     * @return
     */
    List<user> FindAll();

    /**
     * 指定id查询
     */
    user findIdUser(Integer uid);
    /**
     * 指定模糊查询
     */
    List<user> findNameUser(String name);


    /**
     * 通过QueryTo查询
     */
    List<user> QueryToNameUser(QueryTo to);

    /**
     * 通过指定查询条件
     * @param user
     * @return
     */
    List<user> findByConn(user user);

    /**
     * 通过指定一个集合查
     * @param to
     * @return
     */
    List<user> findByAds(QueryTo to);
}
