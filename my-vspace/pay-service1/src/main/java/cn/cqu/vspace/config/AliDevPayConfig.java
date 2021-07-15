package cn.cqu.vspace.config;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;


@Configuration
public class AliDevPayConfig implements Serializable {

    // 这个是支付完成后的跳转路径 可以是一个页面地址等
    public static String returnUrl = "https://www.baidu.com";
    //服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 这个是支付成功失败以后的通知接口会返回相应的参数
    public static String notifyUrl = "http://3111h4q179.zicp.vip/cms/alipay/notify";

    /**支付宝分配给开发者的应用ID*/
    public static String aliPayAppId = "2021000117688743";
    /**
     * 商户id
     */
    public static String uid = "2088621956135011";
    /**支付宝网关*/
    public static String aliPayGateWay = "https://openapi.alipaydev.com/gateway.do";
    public static  String mcloud_api_domain = "http://mcloudmonitor.com/gateway.do";
    /**私钥*/
    public static String aliPayPrivateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC87G83ZkL8jH7XY/W8MSMTSX1D2usNkOjxFerbIQJp+B5Pp6Q3xdCNoFcRfYMJMaUocoYYyTaEDmfFIfrdEF6phDy43LJQaRVXZYcU7Y0Z2Eez5znuf/ZNPMHYeUf4aGA3D3A0Q6MjnCMKjWRoi+o3usRw18AfpOEI6egG2rwhcJ+qbPr557A5psEg4+LCOMyeOJH9ErQ8ILA+RXs4sSh1SFAZYLkgOammNBz66/8oTIy6Hc7Z7F97jsMGnFN2mShrcSzDcYyaSwOC6LoUhHSqv3h6x9LkCBbr4kjHSV6JN9iSVDoWywDYdxzSVZ4xNc1s9BEy2KeH3SofmJ4B3oWdAgMBAAECggEAOmLfpEFoZmCNOsfbxANzkZxeqD/Z8OFd/FQHtx0mf9V8mKV4rPvnjj2FaxRdENRU9IEgTDyzKnDBRT1RKEzM1JrXoVIjkZJIVDA+ZQtdViVvU3wcfUbyucATMHGa+nxXb+zHgn98xZ6VfcdgxqanBf4kg7NJ3v23xmdzm9qx1atOWRCWSWCJ7W4z+tGvBJYQxs12Unmn5xRA9yjqZhiweam+5XxjNWTsNrWV0VfNPOEnGm20VuRQNqcTKR+J+HfVOSTe87xkkcbY3qKCDhBlhUuhsi7JMMS9/yq2CcEAS7/0BKha2tZt+L+zBHel1IweUCKlFYaQstSiMjL1UQjYSQKBgQDwBK7+lc69JEVXHab1q9leJaDgHvh4CKZ+xPRdV5+D81BOzJrZYB17Td7ZDdRYrlo0DLLpPuiFlHdrhEVyfjc8cKtf763h0useRdpVxn8Oq8LUrsFZ+1ixU/wM4xHpwj7Ic8i2lAH5PByaRYZDuhrUWr+S2Oz3P3PXpGNcduh69wKBgQDJgMw55SlQVoXSwXdl/kSrTnmMTckCVAjd/CMQZIfw3veeaxdqSCjmvAKyle9zDONoIM5It38FhZ/gNxmwnIvp/tdknqLgXji0dOfBwPvsj1CuCYxVEanGdqYJEyv6mDQkj/EQwS7K5q2HbUDgnkNbmvO9HeM3ok/T+ZAdXmRrCwKBgFaFybOau2kxjxGFbe934Kbwt5qzb2yN6b8fLtwLP0SozJVrapLb9CTEAIaMVrUVPQ0wWrp8ZAPrblVC3GoWl8Dg+NZfp3YVu44xLjDnmlvmjRhwWuEeG23pUZ4vqQB0dn96RauTlVaMVd9DGtCFYTCV+iNssZe7tv3Qk8T8VHgnAoGAICCB70UjRiTVZ1njQIa+yhVT+dO5Fb7yPvphWM6+gd/62O44KIDizI7zWyfeqphGdaatXRisjuPULrp6RRdgk2lHTEqiq2U6Y0M0ZEbxo7Dh6y2oizOqvvLR3CaLX4P+5Ely5Pn4DO+kgTAhJO72zFczP1bRkGA3nBNxL82J8ysCgYBeg7zhu4v/WF9wZ9fNokm6fjJyzn8FNrj1YTUZONUc4EBSit2xZGnvsDYgPDA9uK9QFZRU+KDBFyVqb0qbfk1h29ITjLdFRFRXD7PsA85eei1KRIfJvJ0EdVmDLxLtEqb9jmBHbCZgqOfhjAQdo0sZk2B8Uqm+oXg+lSN9v4mB2A==";
    /**支付宝公钥 注意是支付宝公钥 不是应用公钥*/
    public static String aliPayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0uSR1YZnpjqSXAv0nCL8I35pjs9EEiFAU90FYvV9dGevKWFROEPgOdRDBtQCqOGxxQSeR5oIMtPUMtWVHF6U/IuKUtUWivi7lMursqAHKZ2KMCB7pi1vJA4y8YNJw5mr7xT2W6JV7/wPwNN0KrZMjzF9sex87YzbgHQy6bcbhrAeaniM9EKBtuafcUyO7ladOEkjc05BNA4GM7lV6lL7xAKRLp/UWyVmoN+hzIQ5Df2LuDvRy6Mav0TV9UDsIsKN4JoPn9N9raL6p2pfQqoe+GpP7R+T2Nt4g+FlmB+h3NiuGN66KrcTH3i7R38J/+crpieGg8BDqasq2hrz74knuwIDAQAB";
    public static String FORMAT = "JSON";

    /**请求使用的编码格式，如utf-8,gbk,gb2312等*/
    public static String CHARSET = "utf-8";

    /**商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2*/
    public static String SIGN_TYPE = "RSA2";
}