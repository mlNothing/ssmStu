package lml;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@RequestMapping("l")
@SessionAttributes(value ={"username","password"},types={Integer.class})
public class two2 {
    @RequestMapping("/testRequestParam")
    public String testParams(@RequestParam(name = "name") String uname,@RequestParam(value="age",required=false)Integer age){
        System.out.println("测试testRequestParam");
        System.out.println(uname+age);
        return "success";
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String Body){
        System.out.println("测试testRequestBody");
        System.out.println(Body);
        return "success";
    }
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("PathVariable");
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String Accept){
        System.out.println("RequestHeader");
        System.out.println(Accept);
        return "success";
    }
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String CookieValue){
        System.out.println("testCookieValue");
        System.out.println(CookieValue);
        return "success";
    }

    /**
     * 被 ModelAttribute 修饰的方法
     * @param
     */
   /* @ModelAttribute
    public void showModel(user user) {
        System.out.println("执行了 showModel 方法"+user.getUname());
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(user user){
        System.out.println("testModelAttribute");
        System.out.println(user.getUname());
        return "success";
    }*/


  /*  @ModelAttribute
    public user showModel(String uname) {
//模拟去数据库查询
        user abc = findUserByName(uname);
        System.out.println("执行了 showModel 方法"+abc);
        return abc;
    }
    private user findUserByName(String uname) {
        user user = new user();
        user.setUname(uname);
        user.setAge(19);
        user.setDate(new Date());
        return user;
    }
    @RequestMapping("/updateUser")
    public String testModelAttributeupdateUser(user user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }*/

    /**
     * 基于 Map 的应用场景示例 1：ModelAttribute 修饰方法不带返回值
     * @param uname
     * @return
     */
   /* @ModelAttribute
    public void showModel(String uname, Map<String,user> map) {
//模拟去数据库查询
        user user = findUserByName(uname);
        System.out.println("执行了 showModel 方法"+user);
        map.put("abc",user);
    }
    private user findUserByName(String uname) {
        user user = new user();
        user.setUname(uname);
        user.setAge(19);
        user.setDate(new Date());
        return user;
    }
    @RequestMapping("/testUpdateUser")
    public String testUpdateUser(@ModelAttribute("abc")user user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }*/



    @RequestMapping("/testPut")
    public String testPut(Model model){
        model.addAttribute("username", "泰斯特");
        model.addAttribute("password","123456");
        model.addAttribute("age", 31);
        //跳转之前将数据保存到 username、password 和 age 中，因为注解@SessionAttribute 中有这几个参数
        return "success";

    }

    @RequestMapping("/testGet")
    public String testGet(ModelMap model){

        System.out.println(model.get("username")+";"+model.get("password")+";"+model.get("age"));
        return "success";
    }

    @RequestMapping("/testClean")
    public String complete(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "success";
    }
}

