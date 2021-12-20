package dao;

import damain.user;

import java.util.List;

public interface IuserDao{
    /**
     * 查找所有的用户,实现一对多
     * @return
     */

    List<user> FindAll();

}
