package com.xpay.order;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * @author Afon, @date 17-03-28
 */
public class OrderTest extends XPayTestBase {

    /**
     * 创建 order
     */
    @Test
    public void testCreateOrder() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("uid", "test_user_001"); // 用户在当前 app 下的 User ID, 可选
        params.put("app", XPayTestData.getAppID()); // App ID, 必传
        params.put("service_app", "5bf0a019ff3648f09bd37d47794ed81b"); // App ID, 必传
        params.put("receipt_app", XPayTestData.getAppID()); // App ID, 必传
        params.put("merchant_order_no", "2017" + System.currentTimeMillis()); // 商户订单号, 必传
        params.put("subject", "ORDER_SUBJECT"); // 商品的标题, 必传
        params.put("body", "ORDER_BODY"); // 商品的描述信息, 必传
        params.put("amount", 2); // 订单总金额，单位：分, 必传
        params.put("currency", "cny"); // 仅支持人民币 cny, 必传
        params.put("uid",XPayTestData.userId);
        params.put("client_ip", "192.168.1.125"); // 客户端的 IP 地址 (IPv4 格式，要求商户上传真实的，渠道可能会判断), 必传
        Map user1 = new HashMap<String, Object>();
        user1.put("user", "user_test_02_01");
        user1.put("amount", 1);
        Map user2 = new HashMap<String, Object>();
        user2.put("user", "user_test_02_02");
        user2.put("amount", 1);

        List users = new ArrayList<Map>();
        users.add(user1);
        users.add(user2);

//        params.put("royalty_users", users);
        params.put("royalty_template", "53653675216896");
        Order obj = Order.create(params); // 创建 Order 对象 方法

        System.out.println(obj);
        assertEquals("status", "created", obj.getStatus());
        assertEquals("paid", false, obj.getPaid());
        assertEquals("refunded", false, obj.getRefunded());
        assertEquals("object should be order", "order", obj.getObject());
        assertEquals("amount", ((Integer) params.get("amount")).intValue(), obj.getAmount().intValue());
        assertEquals("app", params.get("app"), obj.getApp());
//        assertEquals("user ID", params.get("uid"), obj.getUid());
        assertEquals("merchant_order_no", params.get("merchant_order_no"), obj.getMerchantOrderNo());
        assertEquals("subject", params.get("subject"), obj.getSubject());
        assertEquals("body", params.get("body"), obj.getBody());
    }

    /**
     * 支付 order
     */
    @Test
    public void testPayOrder() {
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("channel", "balance");
        params.put("channel", "wx_wap");
        params.put("payment_amount", 2);
        Map<String, Object> extra = new HashMap<String, Object>(); // extra: 根据各个渠道传入相应的参数
        Map<String, Object> combined_with = new HashMap<String, Object>(); // extra: 根据各个渠道传入相应的参数
        extra.put("open_id", "123456");
//        params.put("extra", extra);
        combined_with.put("channel", "balance");
        combined_with.put("payment_amount", 2);
//        params.put("combined_with", combined_with);
        Order order; // 创建支付 Order 对象 方法
        try {
            order = Order.pay("53653681508352", params);
            System.out.println(order);
            assertEquals("status", "created", order.getStatus());
            assertEquals("paid", false, order.getPaid());
            assertEquals("refunded", false, order.getRefunded());
            assertEquals("object should be order", "order", order.getObject());
        } catch (XPayException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 取消 order
     */
    @Test
    public void testCancelOrder() throws XPayException {
        Order order = Order.cancel("53653681508352"); // 取消 Order 对象方法
        System.out.println(order);
        assertEquals("status", "canceled", order.getStatus());
        assertEquals("paid", false, order.getPaid());
        assertEquals("refunded", false, order.getRefunded());
        assertEquals("object should be order", "order", order.getObject());
    }

    /**
     * 查询单个 order
     */
    @Test
    public void testOrderRetrieve() throws XPayException {
        Order obj = Order.retrieve("53652865716224"); // 查询单个 order 方法  参数: orderId

        System.out.println(obj);
        assertNotNull(obj);
        assertEquals("object should be order", "order", obj.getObject());
    }

    /**
     * 获取 order 列表
     */
    @Test
    public void testGetOrderList() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("per_page", 3);
        params.put("paid", true);
        params.put("app", XPayTestData.getAppID());
        params.put("refunded", false);

        OrderCollection objs = Order.list(params); //查询 order 列表方法
        System.out.println(objs);

        assertEquals("object should be list", "list", objs.getObject());
        assertEquals("data count should be same with limit", ((Integer) params.get("per_page")).intValue(), objs.getData().size());
    }

    /**
     * 查询订单中 Payment 对象
     */
    @Test
    public void testOrderPaymentRetrieve() throws XPayException {
        // 查询订单中 Payment 对象
        // 参数一: order id
        // 参数二: payment id
        Payment obj = Order.retrievePayment("53653681508352", "53581016502272");
        System.out.println(obj);
        assertEquals("object should be payment", "payment", obj.getObject());
    }

    /**
     * 查询订单中 Payment 列表
     */
    @Test
    public void testOrderPaymentList() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("per_page", 10);

        // 查询订单中 Payment 列表
        // 参数一: orderId
        // 参数二: params
        PaymentCollection objs = Order.paymentList("53653681508352", params);
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建 order 退款
     */
    @Test
    public void testOrderRefundCreate() throws XPayException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "Order refund test."); // 必传
        params.put("refund_mode", "0");
        params.put("payment", "53653687799808");
        params.put("payment_amount", 2);

        // 创建 order 退款方法
        // 参数一: orderId
        // 参数二: params
        OrderRefundCollection objs = OrderRefund.create("53653681508352", params);
        System.out.println(objs);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询 order 退款
     */
    @Test
    public void testOrderRefundRetrieve() throws XPayException {
        // 查询 order 退款方法
        // 参数一: orderId
        // 参数二: refundId
        Refund obj = OrderRefund.retrieve("53653681508352", "53581089640450");
        System.out.println(obj);
        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询 order 退款列表
     */
    @Test
    public void testOrderRefundList() throws XPayException {

        // 查询 order 退款列表
        // 参数: orderId
        OrderRefundCollection objs = OrderRefund.list("53653681508352");
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }
}
