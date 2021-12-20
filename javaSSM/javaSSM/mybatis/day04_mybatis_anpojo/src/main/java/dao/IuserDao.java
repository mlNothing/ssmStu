package dao;

import damain.user;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IuserDao{
    /**
     * 根据id
     * @param
     * @return
     */
    @Select("select *from user")
    @Results(id ="userMap",value = {
            @Result(id=true,property = "userId",column = "id"),
            @Result(property = "userName",column = "username"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "accounts",column = "id",many=@Many(select = "dao.IaccountDao.FindByAId",fetchType = FetchType.LAZY))
    })
    List<user>  Findall();

    @Select("select *From user where id=#{userID}")
    @ResultMap(value = "userMap")
    user FindById(Integer id);


    /**
     * 更新
     * @param user
     * @return
     */
    @Update("update user set username=#{userName} where id=#{userId}")
    @ResultMap(value="userMap")
    void updateById(user user);

    @Insert("insert into user(username,birthday,sex,address) values(#{userName},#{userBirthday},#{userSex},#{userAddress});")
    void saveUser(user user);

    @Delete("delete from user where id =#{userId}")
    void deleteById(user user);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select *from user where username like #{userName};")
    List<user> findUsername(String username);



    @Select("select *from user where username like '%${value}%';")
    List<user> findUn(String username);

    @Select("select count(*) from user;")
    Integer selectTotal();
}
