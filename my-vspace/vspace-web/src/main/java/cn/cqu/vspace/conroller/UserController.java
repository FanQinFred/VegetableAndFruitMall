package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.PictureService;
import cn.cqu.vspace.service.UserSerivce;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/login")
@CrossOrigin
public class UserController {

    @Reference
    private UserSerivce userService;
    //远程调度: 图片服务器
    @Reference
    private PictureService pictureService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Param("email") String email, @Param("pwd") String pwd) {
        return userService.login(email,pwd);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@Param("token") String token) {
        return userService.logout(token);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Param("email") String email, @Param("pwd") String pwd, @RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
        //注意dubbo不能在不同服务间传递MutipartFile，因为MuitipartFile是不可序列化的,需要转为byte[]
        //commons-io模块中的IOUtils,将输入流转换成字节数组
        byte[] bytes = IOUtils.toByteArray(uploadFile.getInputStream());
        //获取文件大小
        Long fileSize = uploadFile.getSize();
        //获取上传文件的扩展名
        String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        //调用图片服务的方法来上传图片到fastDFS服务器
        String fileUrl = pictureService.upload(bytes, fileSize, extension);

        return userService.register(email,pwd,fileUrl);
    }
}
