package lml.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo01")
public class demo01 {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("运行成功");
        return "success";
    }
}
