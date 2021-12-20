package lml.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//连接数据库的配置类
@Configuration
@PropertySource("classpath:jdbcConfig.properties")
public class jdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name="dataSource")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        System.out.println("111");
        ds.setUser(username);
        ds.setPassword(password);
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);

        System.out.println(username);System.out.println(password);System.out.println(driver);
        System.out.println(url);
        return ds;
    }
    @Bean("runner")//当使用注解时，如果有参数，spring会查找
    public QueryRunner createQueryRunner(DataSource dataSource)
    {
        return new QueryRunner(dataSource);
    }
}
