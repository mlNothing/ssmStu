package service;

import dao.IaccountDao;
import dao.IaccountDaoImpl;
import org.springframework.stereotype.Component;
import pojo.account;

import java.sql.SQLException;
import java.util.List;
@Component("accountService")
public class IaccountServiceImpl implements IaccountService
{
    private IaccountDao accDao;

    public void setAccDao(IaccountDao accDao) {
        this.accDao = accDao;
    }

    public List<account> findAll() throws SQLException {
        return accDao.findAll();
    }

    public account findById(Integer id) throws SQLException {
        return accDao.findById(id);
    }

    public void updateAcc(account acc) throws SQLException {
        accDao.updateAcc(acc);
    }

    public void deleteById(Integer id) throws SQLException {
        accDao.deleteById(id);
    }

    public void insert(account acc) throws SQLException {
        accDao.insert(acc);
    }
}
