package lml.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        ds.setUrl(url);

        return ds;
    }
    @Bean(name="template")//当使用注解时，如果有参数，spring会查找
    public JdbcTemplate createQueryRunner(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}
