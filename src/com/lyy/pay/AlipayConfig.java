package com.lyy.pay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117642970";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRIsB8tQ8XgWkQxD9C+OjUAZZAqLc604c7ftxNVB9nOTT7fC+NXbARpKsSGpy/T1nGRWJ4ZG2I5hnWUGEEF27ayU7ljSLpcLwVOX/uc1kEqAQFmmj8eNnogM8R4JTa/ub0HAsm8uxznLZK5vF9qr6zeLPtaQLDEmtV2ng2tFmdFjDA/z8t4uwO1MInn7rXHqa+LlhdJzVMsVKhIW1aZdpLZq9eeN/dfMK7rSmPLQgibHgxGMMqnLhD6u+WPl+tIOkxamzvYgxxZblIrUEQzFWf5gOZp/frVizKCYwfxyIWPuiqPeyr5tW5hgE6H/eXjIyPlopTGid3eXUwQyVSQl7vAgMBAAECggEAWigzWISEzn42TRMLlUfYIjKmKp5jzCgwnnXM1kCGjXHNBtf7Fh73y8318vYTHwhk5TSe2djQ7jS6IhamXYtM8p4Q46oL4OWGAM1KOk7vImRYsz5bL1LHUpYJi7pt3ahwwX1WNCi9V4gm+VqC8ySI+CXn53fPHmynvppLCPh5nomETpysYKYL9XMEola1Gvq0r2QoE/UzOAlXeLIeL3aT5k8TQIuNNhXi9AEdXYUD5HSCaPIKudIzBabExDzJ/FWCiLeO4YxcYaIqRn5eS4yVFiEeAaS3t9xPk7yhxbsMPIYqLmJqe69Qh4geiIHGPlCP8r5W5Lr2vYe6/vxMOKS4MQKBgQDYEz8x42gQxxOtpABLAaiM9MWD3STKkYZbhDzMY2fWii0s3d7zaA5hQFVDIH6xTT1+mkoybJeypNsUSkQMs04z3Q4ZWJqjru+HZhRJLdOlE6KfPbKHIk1dAuM91+rP9zlveAN9goix3IzFXosR1PUoAxhJJKpslcKfb116N+GmOQKBgQCr8/CD7cuJd6OjXI7lYbI+Uhw5VL6kLC6/YuilzzOreZ7qnnCsp4QrVAqgyUeGKuVSYd0Mm85L5+GEHEjP91eno325z0oqw5cTmmrOyYrpfVcKuNgI1/MtaMmFEVfD4lmcm6jBdhXbBxG1Cl7SAIAMmYh84z4jWeeHFu5JyWxuZwKBgQDKP2G0cZXztlNOAacgjgHVRjsmjTUlwocPXDyIVzdXkehtCZPpI2nqT4w/E8hibtjzirmObySi2zoQyN7fQGofk3bh9JRyR4j+pGayhImJB1L9WIOlh08Ak3ZeaZ7pYA/LrXse3LLUQIsnJrJnU3zRIex2cjJvBtKv506I2ouEyQKBgDliVD7C6ez7ZznKVsnIG8Lehhq/5EtHj2ZBbOCA0H6GPPmRXIrR8LLA/jcAVQU6ZYNjs3BUwrjkLod3JPl6Ut9YGUocGmVBFrbtDn3qFpirQpQKcdYpszbRRIdK7V4quLsh22SMsuiAaHFhf5lXn2QVDM6Yy5DinPihN26acLw7AoGABOhU6Il8gdjDXkZt1JXSZwn6KDlAueqVbg/O+AYu2E4RHKtdSbKADFMWqxyiF4qR4jFu9xH/BBpfNu8daxRFygQxhtawFPC+4muYvA1LNau4PEiux9GciL8QTG3dCmcREHN5AtfhOAai9yeXEX8XGNAn1HNeGcgnW24pS8S5bI4=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj9bUnIh8SZd++dlPcA3puI0qUm5XJ4fem1os0H7Lwe4s5I4SAwlxC/LeUA7hS09xYKC9902Go3NW7LKs6icvcbCj2m6cg9svW/md4JSSXfKbiJLFFUAQcG3OJ50ioKvCAmtCeHwDqwS94SKiK0oQ7SMjjUZBkDu6L6qYavAZ1p7xd00rRz9VFiDCLUvFOnrzbZYB/Z4upscoXVxLCxldkAC9WLzZ7kc+MQQzeAuGa3dOoSR39Nx40XzMkKSsnMsRNCBTgKLSpdycMgJxO1IQpUxHbwAqmHssuQj1SBCyOhvKxKLKUHZc5ArfJ8h5SWxcwhJRkuJwFuk5HnVTyiTdjwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://localhost:8080/alipay/notify_url.jsp";
      public static String notify_url = "http://q3ksjb.natappfree.cc/BookShop/NotifyServlet";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost:8080/alipay/return_url.jsp";
//    public static String return_url = "http://q3ksjb.natappfree.cc/BookShop/Pages/cart/checkout.jsp";
    public static String return_url = "http://q3ksjb.natappfree.cc/BookShop/ReturnUrlServlet";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

