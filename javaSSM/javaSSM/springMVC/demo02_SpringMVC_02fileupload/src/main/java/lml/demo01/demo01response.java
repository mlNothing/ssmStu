package lml.demo01;

import lml.domain.user;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("demo01")
public class demo01response {
    /**
     * 传统文件上传的方式
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileLoad1")
    public String fileLoad1(HttpServletRequest request) throws Exception {
        //先获取到要上传得文件目录
        String path = request.getSession().getServletContext().getRealPath("/upLoad");
        //创建file对象，一会向该路径下上传文件
        File file = new File(path);
        System.out.println(path);
        //判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        //遍历
        for (FileItem fileItem : list) {
            //判断文件项，还是上传得文件
            if (fileItem.isFormField()){

            }else {
                //获取到上传文件得名称
                String name = fileItem.getName();
                //上传文件
                fileItem.write(new File(file,name));

                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    /**
     * springMVC传统方式文件上传
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileLoad2")
    public String fileLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        //先获取到要上传得文件目录
        String path = request.getSession().getServletContext().getRealPath("/upLoad");
        //创建file对象，一会向该路径下上传文件
        File file = new File(path);
        //判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()){
            file.mkdirs();
        }
       //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
       filename= uuid+"_"+filename;
       //上传文件
       upload.transferTo(new File(file,filename));

        return "success";
    }
}

