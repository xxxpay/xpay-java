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
        params.put("merchant_order_no", "2017" + System.currentTimeMillis()); // 商户订单号, 必传
        params.put("subject", "ORDER_SUBJECT"); // 商品的标题, 必传
        params.put("body", "ORDER_BODY"); // 商品的描述信息, 必传
        params.put("amount", 100); // 订单总金额，单位：分, 必传
        params.put("currency", "cny"); // 仅支持人民币 cny, 必传
        params.put("uid","123");
        params.put("client_ip", "192.168.1.125"); // 客户端的 IP 地址 (IPv4 格式，要求商户上传真实的，渠道可能会判断), 必传
        Map user1 = new HashMap<String, Object>();
        user1.put("user", "123");
        user1.put("amount", 100);


        List users = new ArrayList<Map>();
        users.add(user1);

        params.put("royalty_users", users);
        Order obj = Order.create(params); // 创建 Order 对象 方法

        System.out.println(obj);
        assertEquals("object should be order", "order", obj.getObject());
        assertEquals("amount", ((Integer) params.get("amount")).intValue(), obj.getAmount().intValue());
        assertEquals("app", params.get("app"), obj.getApp());
        assertEquals("user ID", params.get("uid"), obj.getUid());
        assertEquals("merchant_order_no", params.get("merchant_order_no"), obj.getMerchantOrderNo());
        assertEquals("subject", params.get("subject"), obj.getSubject());
        assertEquals("body", params.get("body"), obj.getBody());
    }

    /**
     * 支付 order
     */
    @Test
    public void testPayOrder() {
        Map<String, Object> params = new HashMap<>();
        params.put("channel", "wx_lite");
        params.put("payment_amount", 100);
        Map<String, Object> extra = new HashMap<>(); // extra: 根据各个渠道传入相应的参数
        extra.put("open_id", "123456");
        params.put("extra", extra);
        Order order; // 创建支付 Order 对象 方法
        try {
            order = Order.pay("3e4948ae229945adbc490d0980ed3067", params);
            System.out.println(order);
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
        Order order = Order.cancel("2001708220000280391"); // 取消 Order 对象方法

        assertEquals("object should be order", "order", order.getObject());
    }

    /**
     * 查询单个 order
     */
    @Test
    public void testOrderRetrieve() throws XPayException {
        Order obj = Order.retrieve("3e4948ae229945adbc490d0980ed3067"); // 查询单个 order 方法  参数: orderId

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
        params.put("paid", false);
        params.put("app", XPayTestData.getAppID());
        params.put("refunded", false);

        OrderCollection objs = Order.list(params); //查询 order 列表方法

        assertEquals("object should be list", "list", objs.getObject());
        assertEquals("data count should be same with limit", ((Integer) params.get("per_page")).intValue(), objs.getData().size());
    }

    /**
     * 查询订单中 Payment 对象
     */
    @Test
    public void testOrderChargeRetrieve() throws XPayException {
        // 查询订单中 Payment 对象
        // 参数一: order id
        // 参数二: charge id
        Payment obj = Order.retrieveCharge("2001708220000221911", "ch_88mbTKu9mbn9mfT4KSCiHiX5");
        assertEquals("object should be charge", "charge", obj.getObject());
    }

    /**
     * 查询订单中 Payment 列表
     */
    @Test
    public void testOrderChargeList() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 10);

        // 查询订单中 Payment 列表
        // 参数一: orderId
        // 参数二: params
        ChargeCollection objs = Order.chargeList("2001708220000221911", params);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建 order 退款
     */
    @Test
    public void testOrderRefundCreate() throws XPayException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "Order refund test."); // 必传
        params.put("refund_mode", "to_source");

        // 创建 order 退款方法
        // 参数一: orderId
        // 参数二: params
        OrderRefundCollection objs = OrderRefund.create("2001708220000281981", params);

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
        Refund obj = OrderRefund.retrieve("2001708220000258501", "re_5GefjD14GW50qrT40Gq9KmPS");
        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询 order 退款列表
     */
    @Test
    public void testOrderRefundList() throws XPayException {

        // 查询 order 退款列表
        // 参数: orderId
        OrderRefundCollection objs = OrderRefund.list("2001708220000258501");
        assertEquals("object should be list", "list", objs.getObject());
    }
}
