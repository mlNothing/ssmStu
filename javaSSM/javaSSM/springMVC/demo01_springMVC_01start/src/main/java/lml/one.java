package lml;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("lml")
public class one {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("测试开始了");
        return "success";
    }



    @RequestMapping(value = "/saveAccount",method= RequestMethod.POST)
    public String saveAccount(){
        System.out.println("保存开始了");
        return "success";
    }
    @RequestMapping(value = "/removeAccount",params = {"accountName","money>100"})
    public String removeAccount(){
        System.out.println("保存开始了");
        return "success";
    }

    /**
     * 自定义类型转换器-
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteAcc")
    public String deleteAcc(user user){
        System.out.println(user);
        System.out.println("类型转换成功了");
        return "success";
    }
}
