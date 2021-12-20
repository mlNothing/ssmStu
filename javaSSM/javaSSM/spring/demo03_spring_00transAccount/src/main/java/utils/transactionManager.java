package utils;

import java.sql.SQLException;

public class transactionManager {
    private connectionUtils connectionUtil;

    public void setConnectionUtil(connectionUtils connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    public void beginTransaction()
    {
        //关闭自动提交
        try {
             connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void commit()
    {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void rollback()
    {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void close()
    {
        try {
            connectionUtil.getThreadConnection().close();
            connectionUtil.removeThreadConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
