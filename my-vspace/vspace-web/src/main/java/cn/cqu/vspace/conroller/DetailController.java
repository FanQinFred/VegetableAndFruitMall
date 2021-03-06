package cn.cqu.vspace.conroller;

import cn.cqu.vspace.pojo.Goods;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import cn.cqu.vspace.service.DetailService;

import java.util.List;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/detail")
@CrossOrigin
public class DetailController {
    //使用dubbo注解远程调用user-service
    @Reference
    private DetailService detailService;

    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public List<Goods> productDetail() {
        return detailService.productDetail();
    }

    //    String goodsid, String blogid, String yourName, String yourEmail, String yourView, String rating, String token
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment( @RequestHeader("token") String token,@Param("goodsid") String goodsid, @Param("blogid") String blogid,@Param("yourName")  String yourName,@Param("yourEmail")  String yourEmail,@Param("yourView")  String yourView, @Param("rating") String rating) {
        return detailService.comment( goodsid,  blogid,  yourName,  yourEmail,  yourView,  rating,  token);
    }
}
