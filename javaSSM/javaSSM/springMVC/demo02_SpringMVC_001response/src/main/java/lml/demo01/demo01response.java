package lml.demo01;

import lml.domain.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("demo01")
public class demo01response {
    @RequestMapping("/testVoid")
    public String testVoid(Model model){
        user user = new user();
        user.setUsername("张三");
        user.setPassword("123");
        user.setMoney(100);
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/testReturnVoid")
    public void testReturnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试无返回值");
        //1、使用 request 转向页面
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //2、也可以通过 response 指定响应结果
        response.sendRedirect("testVoid");
        //3、也可以通过 response 指定响应结果
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("json 串");
        return ;
    }
    @RequestMapping("/testReturnModelAndView")
    public ModelAndView testReturnModelAndView()  {
        //ModelAndView 是 SpringMVC 为我们提供的一个对象，该对象也可以用作控制器方法的返回值。
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("one","张三");
        /*我们在页面上上获取使用的是 requestScope.one取的，所以返回 ModelAndView 类型时，浏
        览器跳转只能是请求转发。*/
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testForward")
    public String testForward()  {
        System.out.println("测试转发");;
        /*需要注意的是，如果用了 formward：则路径必须写成实际视图 url，不能写逻辑视图。
        它相当于“request.getRequestDispatcher("url").forward(request,response)”。使用请求
        转发，既可以转发到 jsp，也可以转发到其他的控制器方法。
        */
        return "forward:/WEB-INF/pages/success.jsp";
    }
    @RequestMapping("/testRedirect")
    public String testRedirect()  {
        System.out.println("测试转发");
        /*它相当于“response.sendRedirect(url)”。需要注意的是，如果是重定向到 jsp 页面，则 jsp 页面不
    能写在 WEB-INF 目录中，否则无法找到。*/
        return "redirect:testReturnModelAndView";
    }

    /**
     * 获取请求体的数据,异步请求
     */
    @RequestMapping("/testJson")
    public  @ResponseBody user testJson(@RequestBody user user){
        System.out.println(user);
        user.setUsername("bb");
        return user;
    }
}

