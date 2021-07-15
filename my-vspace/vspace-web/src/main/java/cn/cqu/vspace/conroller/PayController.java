package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.impl.PayServiceImp;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/alipay")
@RestController
public class PayController {

    @Reference
    PayServiceImp payServiceImp;

    @RequestMapping(value = "/pay")
    public String aliPay(@RequestParam("id")String id,
                         @RequestParam("type")String type,@RequestParam("money")String money) throws IOException {
        return payServiceImp.aliPay(id,type,money);
    }


    @RequestMapping ("/notify")
    public void payNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        payServiceImp.alipayNotify(request,response);
    }

}
