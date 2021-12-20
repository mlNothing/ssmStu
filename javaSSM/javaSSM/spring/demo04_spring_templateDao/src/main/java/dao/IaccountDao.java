package dao;

import pojo.account;

import java.util.List;

public interface IaccountDao {
    //查询所有
    List<account> findAll();
    //查询一个
    account findById(Integer id);
    account findByName(String name);
    //插入
    void insertAcc(account account);
    //删除
    void deleteAcc(Integer id);
    //更新
    void updateAcc(account account);
}
