package dao;


import damain.account;
import damain.user;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IaccountDao {
    /**
     * 根据id
     * @param
     * @return
     */
    @Select("select *from account")
    @Results(id ="accountMap",value = {
            @Result(id=true,property = "ID",column = "id"),
            @Result(property = "UID",column = "uid"),
            @Result(property = "MONEY",column = "money"),
            @Result(property = "user",column = "uid",one=@One(select = "dao.IuserDao.FindById",fetchType = FetchType.EAGER))
    })
    List<account>  Findacc();

    @Select("select *From account where id=#{ID}")
    @ResultMap(value = "accountMap")
   account FindByAId(Integer id);

}
