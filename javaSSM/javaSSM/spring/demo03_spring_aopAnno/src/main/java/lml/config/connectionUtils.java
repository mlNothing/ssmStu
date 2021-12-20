package lml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*连接的工具类，它用于从数据源中获取一个连接，并实现和线程的绑定*/
@Component("connectionUtils")
public class connectionUtils {
  private ThreadLocal<Connection> t1=  new ThreadLocal<Connection>();
  @Autowired
    private DataSource ds;

    //获取当前线程上的连接
    public Connection getThreadConnection(){
        Connection connection = t1.get();
        //判断是否有连接
        if (connection==null)
        {
            //从数据源中获取一个连接并且存入threadLocal中
            try {
                connection= ds.getConnection();
                t1.set(connection);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
    //把连接从线程上解绑
    public void removeThreadConnection(){

        t1.remove();
    }
}
