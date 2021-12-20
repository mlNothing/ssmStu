package dao;

import damain.user;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IuserDao {
    /**
     * 查找所有的数据
     * */
    @Select("select *from user")
    public List<user> FindAll();
}
