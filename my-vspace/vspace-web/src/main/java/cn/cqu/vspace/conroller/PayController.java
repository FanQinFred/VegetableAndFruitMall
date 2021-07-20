package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.PayService;
import cn.cqu.vspace.service.impl.PayServiceImp;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/alipay")
@RestController
@CrossOrigin
public class PayController {

    @Reference
    PayService payService;

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String aliPay(@RequestParam("id")String id,
                         @RequestParam("type")String type,@RequestParam("money")String money) throws IOException {
        return payService.aliPay(id,type,money);
    }


    @RequestMapping ("/notify")
    public void payNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        payService.alipayNotify(request,response);
    }

}
