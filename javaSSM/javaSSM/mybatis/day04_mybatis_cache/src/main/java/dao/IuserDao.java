package dao;

import damain.user;

import java.util.List;

public interface IuserDao{
    /**
     * 根据id
     * @param i
     * @return
     */

    user  FindById(int i);

    /**
     * 更新
     * @param user
     * @return
     */
    void updateById(user user);

}
