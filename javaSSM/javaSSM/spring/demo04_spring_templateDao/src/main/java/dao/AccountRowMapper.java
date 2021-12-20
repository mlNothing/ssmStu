package dao;

import org.springframework.jdbc.core.RowMapper;
import pojo.account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<account> {
    public account mapRow(ResultSet resultSet, int i) throws SQLException {
        account account = new account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
