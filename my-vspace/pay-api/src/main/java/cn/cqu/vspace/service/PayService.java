package cn.cqu.vspace.service;

import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface PayService {
    String aliPay(String id,String money);
    void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, UnsupportedEncodingException;
}
