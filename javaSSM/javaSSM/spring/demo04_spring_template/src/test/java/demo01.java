import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class demo01 {
    @Test
    public void one01(){
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) cp.getBean("jdbcTemplate");
        jdbcTemplate.execute("insert into account values(NULL ,'DD',10)");
    }
    @Test
    public void one02(){
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) cp.getBean("jdbcTemplate");
        jdbcTemplate.update("insert into account values(NULL ,?,?)","cc",100);
    }
    @Test
    public void one03(){
        ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) cp.getBean("jdbcTemplate");
       int a= jdbcTemplate.queryForObject("select count(*) from account where money > ?",Integer.class,10);
        System.out.println(a);
    }
}
