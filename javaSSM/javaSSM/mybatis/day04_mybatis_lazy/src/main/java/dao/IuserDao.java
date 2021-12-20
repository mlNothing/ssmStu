package dao;

import damain.user;

import java.util.List;

public interface IuserDao{

    /**
     * 查询用户，同时获取出每个用户下的所有账户信息
     * @return
     */
    List<user> findAll();
    /**
     * 根据用户 id 查询账户信息
     * @return
     */

    user findById(Integer userId);

}
