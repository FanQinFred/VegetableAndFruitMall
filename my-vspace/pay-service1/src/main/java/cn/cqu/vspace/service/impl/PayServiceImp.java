package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.config.AliDevPayConfig;
import cn.cqu.vspace.service.PayService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PayServiceImp implements PayService {
    @Override
    public String aliPay(String id, String type, String money) {
        //非法参数 抛出异常
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(type) || StringUtils.isEmpty(money)) {
            return null;
        }
        //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
        AlipayClient alipayClient = new DefaultAlipayClient(AliDevPayConfig.aliPayGateWay, AliDevPayConfig.aliPayAppId,
                AliDevPayConfig.aliPayPrivateKey, AliDevPayConfig.FORMAT, AliDevPayConfig.CHARSET, AliDevPayConfig.aliPayPublicKey,
                AliDevPayConfig.SIGN_TYPE);
        //实例化具体API对应的request类
        AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
        payRequest.setNotifyUrl(AliDevPayConfig.notifyUrl);
        payRequest.setReturnUrl(AliDevPayConfig.returnUrl);
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
        AlipayTradePagePayModel payModel = new AlipayTradePagePayModel();
        //商户订单号
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        payModel.setOutTradeNo(uid);
        //对一笔交易的具体描述信息。这里存储用户id
        payModel.setBody(id);
        //商品名称
        payModel.setSubject(type);
        //交易超时时间 这里的30m就是30分钟
        payModel.setTimeoutExpress("30m");
        //支付金额 后面保留2位小数点..不能超过2位
        payModel.setTotalAmount(money);
        // //电脑网站支付销售产品码，不同的支付方式productCode不同 销售产品码（固定值）
        payModel.setProductCode("FAST_INSTANT_TRADE_PAY");
        payRequest.setBizModel(payModel);
        try {
            // 这里和普通的接口调用不同，使用的是sdkExecute
            //返回支付宝订单信息(预处理)
            AlipayTradePagePayResponse alipayTradePagePayResponse = alipayClient.pageExecute(payRequest);
            //就是orderString 可以直接给APP请求，无需再做处理。
            return alipayTradePagePayResponse.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, UnsupportedEncodingException {
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK签名验证
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AliDevPayConfig.aliPayPublicKey, AliDevPayConfig.CHARSET, AliDevPayConfig.SIGN_TYPE);
        if (signVerified) {
            //商户订单号
            String uid = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //用户id
            String userId = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");
            //健身房会员卡类型
            String type = new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");
            //金额
            String money = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            /*
　　　　　　　　　这里编写业务逻辑　
　　　　　　　　*/
        }
    }
}

