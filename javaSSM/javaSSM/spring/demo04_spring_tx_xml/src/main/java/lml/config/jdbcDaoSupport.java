package lml.config;

import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class jdbcDaoSupport  extends DaoSupport {
    private JdbcTemplate jdbcTemplate;
    //set 方法注入数据源，判断是否注入了，注入了就创建 JdbcTemplate
    public final  void  setDataSourc(DataSource dataSourc) {
        if (jdbcTemplate==null||dataSourc!=jdbcTemplate.getDataSource()){
            this.jdbcTemplate=createJdbcTemplate(dataSourc);
        }
    }
    //使用数据源注入jdbcTemplate
    protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);  }
//
//        //也可以通过注入JdbcTemplate对象
//    public  final void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//       // initTemplateConfig();
//    }




    public final JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
