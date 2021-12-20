package lml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lm")
public class two {
    /**
     * 基本类型参数：包括基本类型和 String 类型
     * @param id
     * @return
     */
    @RequestMapping("/testParams")
    public String testParams(Integer id){
        System.out.println("测试基本数据类型");
        System.out.println(id);
        return "success";
    }

    /**
     * POJO 类型参数：POJO 类型参数：
     * @param
     * @return
     */
    @RequestMapping("/testPojo")
    public String testPojo(account account){
        System.out.println("测试pojo型");
        System.out.println(account);
        return "success";
    }

    /**
     * 测试pojo类以及关联类
     * @param account
     * @return
     */
    @RequestMapping("/testPojoUser")
    public String testPojoUser(account account){
        System.out.println("pojo以及关联的实体类");
        System.out.println(account);
        return "success";
    }

    /**
     *第一种：
     * 要求集合类型的请求参数必须在 POJO 中。在表单中请求参数名称要和 POJO 中集合属性名称相同。
     * 给 List 集合中的元素赋值，使用下标。
     * 给 Map 集合中的元素赋值，使用键值对。
     * 第二种：
     * 接收的请求参数是 json 格式数据。需要借助一个注解实现。
     * @param account
     * @return
     */
    @RequestMapping("/testPojoListMap")
    public String testPojoListMap(account account){
        System.out.println("pojo以及集合");
        System.out.println(account);
        return "success";
    }

}
