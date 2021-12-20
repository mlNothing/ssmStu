package lml.demo01;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("demo01")
public class imageServlet {

    @RequestMapping("/upload1")
        public String file( MultipartFile upload) throws IOException {
        String path="http://localhost:8080/demo02_SpringMVC_03imageServlet/demo01/upload/";

        //获取到文件上传的名字
        String originalFilename = upload.getOriginalFilename();
        String s = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        originalFilename=s+"_"+originalFilename;
        //向图片服务器上传文件
        Client client = Client.create();
        WebResource resource = client.resource(path + originalFilename);
        resource.put(upload.getBytes());
        return  "success";
        }
}
