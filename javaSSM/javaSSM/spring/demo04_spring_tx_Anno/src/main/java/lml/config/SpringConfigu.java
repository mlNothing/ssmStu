package lml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//用于指定当前类是一个spring配置类，当创建容器式时会从该类上加载注解 作用就是和bean.xml一样
@Configuration
@ComponentScan("lml")//用于指定spring在初始化容器时要扫描的包
@Import({jdbcConfig.class,TransactionConfig.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfigu {
}
