package dao;

import damain.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IuserDao{
    /**
     * 根据id
     * @param
     * @return
     */
    @Select("select *from user")
    List<user>  Findall();

    /**
     * 更新
     * @param user
     * @return
     */
    @Update("update user set username=#{username} where id=#{id}")
    void updateById(user user);

    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address});")
    void saveUser(user user);

    @Delete("delete from user where id =#{id}")
    void deleteById(user user);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select *from user where username like #{username};")
    List<user> findUsername(String username);



    @Select("select *from user where username like '%${value}%';")
    List<user> findUn(String username);

    @Select("select count(*) from user;")
    Integer selectTotal();
}
