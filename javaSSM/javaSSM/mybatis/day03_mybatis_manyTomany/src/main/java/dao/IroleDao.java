package dao;

import damain.role;
import damain.user;

import java.util.List;

public interface IroleDao {
    /**
     * 查找所有的用户,实现一对多
     * @return
     */

    List<role> FindAll();

    List<role> FindAllUser();

}
