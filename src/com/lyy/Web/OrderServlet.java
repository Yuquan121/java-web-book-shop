package com.lyy.Web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.Product;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.lyy.Service.Impl.OrderServiceImpl;
import com.lyy.Service.OrderService;
import com.lyy.domain.Cart;
import com.lyy.domain.Order;
import com.lyy.pay.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: Moon
 */

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        domain.User loginUser = (domain.User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/Pages/Login.jsp").forward(req, resp);
            return;
        }

        Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
        Order order = orderService.createOrder(cart, userId);
        String orderId = order.getOrderId();

        req.getSession().setAttribute("orderId", orderId);

        //向支付宝发送请求
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderId + "";
        //付款金额，必填
        String total_amount = order.getPrice()+"";
        //订单名称，必填
        String subject = orderId + "";
        String body = "商品描述";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        System.out.println("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //        + "\"total_amount\":\""+ total_amount +"\","
        //        + "\"subject\":\""+ subject +"\","
        //        + "\"body\":\""+ body +"\","
        //        + "\"timeout_express\":\"10m\","
        //        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        AlipayTradePagePayResponse alipayResponse = null;
        try {
            alipayResponse = alipayClient.pageExecute(alipayRequest);
            System.out.println(alipayResponse.getBody());
            System.out.println(alipayResponse.getMsg());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(alipayResponse.getBody());


        //resp.sendRedirect(req.getContextPath() + "/Pages/cart/checkout.jsp");

    }


}
