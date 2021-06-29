package com.xpay.recharge;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RechargeTest extends XPayTestBase {
    /**
     * 创建 recharge
     */
    @Test
    public void testRechargeCreate() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user", XPayTestData.userId); // 充值目标用户 ID, 必传
//        params.put("user_fee", 1);     // 用户充值收取的手续费，单位分，不得大于 amount，不可和 balance_bonus[amount] 同时传，默认 0。可选
        params.put("description", "魔范优选"); // 描述, 可选
        Map<String, Object> payment = new HashMap<String, Object>();
        payment.put("amount", 180); // 用户实际支付金额，单位分, 必传
        payment.put("channel", "wx_wap"); // 支付使用的第三方支付渠道, 必传
        payment.put("order_no", "2021" + System.currentTimeMillis()); // 商户订单号，适配每个渠道对此参数的要求，必须在商户系统内唯一, 必传
        payment.put("client_ip", "192.168.1.132");   // 客户端的 IP，IPv4，默认 127.0.0.1, 可选
        payment.put("subject", "发卡"); // 充值标题，该参数最长为 32 个 Unicode 字符, 必传
        payment.put("body", "莫兰迪色简约侧边发夹鸭嘴夹韩国网红刘海夹碎发卡后脑勺一字顶夹"); // 充值描述信息，该参数最长为 128 个 Unicode 字符, 必传
        Map<String, Object> extra = new HashMap<String, Object>(); // extra: 根据不同渠道传入相应的参数
        extra.put("success_url", "https://api-test.lucfish.com/xpay");
        payment.put("extra", extra);
        params.put("payment", payment);
        Recharge obj = Recharge.create(params); // 创建 recharge 方法
        System.out.println(obj);
        assertEquals("succeeded", false, obj.getSucceeded());
        assertEquals("refunded", false, obj.getRefunded());
        assertEquals("object should be recharge", "recharge", obj.getObject());
    }

    /**
     * 查询单个 recharge
     */
    @Test public void testRechargeRetrieve() throws XPayException {
        // 查询单个 recharge 方法
        // 参数: rechargeId
        Recharge obj = Recharge.retrieve("53562876661760");
        System.out.println(obj);
        assertEquals("object should be recharge", "recharge", obj.getObject());
    }

    /**
     * 查询 recharge 列表
     */
    @Test public void testRechargeList() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("per_page", 3);
        params.put("user", XPayTestData.userId); // 充值目标用户 ID, 必传
        params.put("from_user", XPayTestData.userId); //
//        params.put("succeeded", true); // 是否已充值成功
//        params.put("refunded", true); // 是否存在退款 (跟是否退款成功没有关系)
        params.put("payment[channel]", "wx_wap"); // 充值使用的支付渠道。
//        params.put("payment[order_no]", "2017162426973615"); // 。
//        params.put("created[gt]", 1624269737000L); // 。
//        params.put("created[gte]", 1624269737000L); // 。
//        params.put("created[lte]", 1624270002000L); // 。
//        params.put("created[lt]", 1624270002000L); // 。

        // 查询 recharge 列表方法
        // 参数: params
        RechargeCollection objs = Recharge.list(params);
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建 recharge_refund
     */
    @Test public void testRechargeRefundCreate() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("description", "Recharge Refund Description"); // 必传
        // 创建 recharge_refund 方法
        // 参数一: rechargeId
        // 参数二: params
        Refund obj = RechargeRefund.create("53537250250752", params);
        System.out.println(obj);
        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询单个 recharge_refund
     */
    @Test public void testRechargeRefundRetrieve() throws XPayException {
        // 查询单个 recharge_refund 方法
        // 参数一: rechargeId
        // 参数二: refundId
        Refund obj = RechargeRefund.retrieve("53537250250752", "53537294553090");
        System.out.println(obj);
        assertEquals("object should be refund", "refund", obj.getObject());
    }

    /**
     * 查询 recharge_refund 列表
     */
    @Test public void testRechargeRefundList() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询 recharge_refund 列表方法
        // 参数一: rechargeId
        // 参数二: params
        RechargeRefundCollection objs = RechargeRefund.list("53537250250752", params);
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }
}
