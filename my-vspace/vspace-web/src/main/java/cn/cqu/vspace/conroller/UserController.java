package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.UserSerivce;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/login")
public class UserController {

    @Reference
    private UserSerivce userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Param("email") String email, @Param("pwd") String pwd) {
        return userService.login(email,pwd);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@Param("email") String email, @Param("pwd") String pwd) {
        return userService.logout(email,pwd);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Param("email") String email, @Param("pwd") String pwd) {
        return userService.register(email,pwd);
    }
}
