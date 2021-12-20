package dao;

import damain.account;

import java.util.List;

public interface IaccountDao {
    /**
     * 查找所有的用户
     * @return
     */
    List<account> FindAll();

    /**
     * 通过accountUser查找所有
     * @return
     */

    List<account> findByFindByUid(Integer uid);


}
