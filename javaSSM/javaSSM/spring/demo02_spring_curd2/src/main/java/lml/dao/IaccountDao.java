package lml.dao;

import lml.pojo.account;

import java.sql.SQLException;
import java.util.List;

public interface IaccountDao {
    //查询
    List<account> findAll() throws SQLException;
    //根据id查询
    account findById(Integer id) throws SQLException;
    //更新
    void updateAcc(account acc) throws SQLException;
    //删除
    void deleteById(Integer id) throws SQLException;
    //增加
    void insert(account acc) throws SQLException;
}
