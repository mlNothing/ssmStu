package dao;

import damain.user;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IuserDao {
    /**
     * 查找所有的用户
     * @return
     */
    List<user> FindAll();

    /**
     * 添加用户保存
     * @param user
     */
    void saveUser(user user);
    /**
     * 更新用户
     */
    void updateUser(user user);
    /**
     * 删除指定id
     */
    void deleteIdUser(Integer uid);

    /**
     * 指定id查询
     */
    user findIdUser(Integer uid);
    /**
     * 指定模糊查询
     */
    List<user> findNameUser(String name);

    /**
     * 查询总的条数
     */
    int findTotal(user user);


}
