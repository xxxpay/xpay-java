package com.xpay;

import com.xpay.exception.XPayException;
import com.xpay.model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'Afon' at '16-12-16 上午10:33' with Gradle 3.1
 *
 * @author Afon, @date 16-12-16 上午10:33
 */
public class XPayTest {

    @BeforeClass
    public static void initApiKey() {
        XPay.overrideApiBase(XPayTestData.getApiBase());
        XPay.apiKey = XPayTestData.getApiKey();
        // 建议使用 PKCS8 编码的私钥，可以用 openssl 将 PKCS1 转成 PKCS8
        XPay.privateKey = XPayTestData.getPKCS8PrivateKey();
        XPay.DEBUG = true;
    }

    @Test
    public void testSetApiKey() {
        assertEquals("apiKey should be set", "sk_test_ibbTe5jLGCi5rzfH4OqPW9KC", XPay.apiKey);
    }

    @Test
    public void testVerifyVersions() {
        assertEquals("XPay.VERSION should match", "2.4.0", XPay.VERSION);
    }

    @Test
    public void testCreatePayment() {
        String appId = XPayTestData.getAppID();

        Payment payment = null;
        Map<String, Object> pamentMap = new HashMap<String, Object>();
        pamentMap.put("amount", 1);//订单总金额, 人民币单位：分（如订单总金额为 1 元，此处请填 100）
        pamentMap.put("currency", "cny");
        pamentMap.put("subject", "Your Subject");
        pamentMap.put("body", "Your Body");
        String orderNo = "orderno" + new Date().getTime();
        pamentMap.put("order_no", orderNo);// 推荐使用 8-20 位，要求数字或字母，不允许其他字符
        pamentMap.put("channel", "wx_wap");// 支付使用的第三方支付渠道取值，请参考：https://www.xpay.com/api#api-c-new
        pamentMap.put("client_ip", "192.168.1.132"); // 发起支付请求客户端的 IP 地址，格式为 IPV4，如: 127.0.0.1
        Map<String, String> app = new HashMap<String, String>();
        app.put("id", appId);
        pamentMap.put("app", app);

        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("open_id", "123456");
        pamentMap.put("extra", extra);
        try {
            // 发起 payment 创建请求
            payment = Payment.create(pamentMap);
            // 传到客户端请先转成字符串 .toString(), 调该方法，会自动转成正确的 JSON 字符串
            String pamentString = payment.toString();
            System.out.println(pamentString);
        } catch (XPayException e) {
            e.printStackTrace();
        }

        assertNotNull(payment);
        assertEquals("payment object should be payment", "payment", payment.getObject());
        assertEquals("payment order_no", orderNo, payment.getOrderNo());
    }

    @Test
    public void testWebhooksParsePayment() {
        String webhookData = XPayTestData.getPaymentWebhooksData();

        XPayObject obj = Webhooks.getObject(webhookData);

        assertTrue("object should be an instance of Payment", obj instanceof Payment);
        assertEquals("object should be pament", "pament", ((Payment) obj).getObject());
    }

    @Test
    public void testWebhooksParseBatchTransfer() {
        String webhookData = XPayTestData.getBatchTransferWebhooksData();

        XPayObject obj = Webhooks.getObject(webhookData);

        assertTrue("object should be an instance of BatchTransfer", obj instanceof BatchTransfer);
        assertEquals("object should be batch_transfer", "batch_transfer", ((BatchTransfer) obj).getObject());
    }

    @Test
    public void testGetPaymentList() {
        try {
            Integer limit = 3;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("app[id]", XPayTestData.getAppID());
            params.put("limit", limit);
            PaymentCollection chs = Payment.list(params);

            System.out.println(chs);
            assertEquals("object should be list", "list", chs.getObject());
            assertEquals("data count should be same with limit", limit.intValue(), chs.getData().size());
        } catch (XPayException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBatchRefundList() {
        try {
            Integer limit = 3;
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("per_page", limit);
            BatchRefundCollection objs = BatchRefund.list(params);

            assertEquals("object should be list", "list", objs.getObject());
            assertEquals("data count should be same with per_page", limit.intValue(), objs.getData().size());
        } catch (XPayException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateTransfer() {
        try {
            String orderNo = "2017" + new Date().getTime();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("amount", 100);
            params.put("currency", "cny");
            params.put("type", "b2c");
            params.put("order_no", orderNo);
            params.put("channel", "wx");
            params.put("recipient", "123456");


            params.put("description", "Your description.");
            Map<String, String> app = new HashMap<String, String>();
            app.put("id", XPayTestData.getAppID());
            params.put("app", app);
            Transfer obj = Transfer.create(params);
            System.out.println(obj);

            assertEquals("object should be transfer", "transfer", obj.getObject());
            assertEquals("amount should be same", params.get("amount"), obj.getAmount());
            assertEquals("order_no should be same", params.get("order_no"), obj.getOrderNo());
            assertEquals("description should be same", params.get("description"), obj.getDescription());
            assertEquals("channel should be same", params.get("channel"), obj.getChannel());
        } catch (XPayException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateBatchTransfer() throws XPayException {

        String batchNo = "2017" + new Date().getTime();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", XPayTestData.getAppID());
        params.put("amount", 1000);
        params.put("currency", "cny");
        params.put("type", "b2c");
        params.put("batch_no", batchNo);
        params.put("channel", "alipay");
        params.put("description", "Batch transfer description.");

        List<Map<String, Object>> recipients = new ArrayList<Map<String, Object>>();
        params.put("recipients", recipients);

        Map<String, Object> recipient1 = new HashMap<String, Object>();
        recipient1.put("account", "user001@gmail.com");
        recipient1.put("name", "user001");
        recipient1.put("amount", 600);
        recipient1.put("description", "Recipient 1 description.");
        recipients.add(recipient1);

        Map<String, Object> recipient2 = new HashMap<String, Object>();
        recipient2.put("account", "user002@gmail.com");
        recipient2.put("name", "user002");
        recipient2.put("amount", 400);
        recipient2.put("description", "Recipient 2 description.");
        recipients.add(recipient2);

        BatchTransfer obj = BatchTransfer.create(params);

        assertEquals("object should be batch_transfer", "batch_transfer", obj.getObject());
        assertEquals("amount should be same", params.get("amount"), obj.getAmount());
        assertEquals("batch_no should be same", params.get("batch_no"), obj.getBatchNo());
        assertEquals("description should be same", params.get("description"), obj.getDescription());
        assertEquals("channel should be same", params.get("channel"), obj.getChannel());
        for (int i = 0; i < obj.getRecipients().size(); i++) {
            assertNotNull("order_no should not be null", obj.getRecipients().get(i).getOrderNo());
            assertNull("failure_msg should be null", obj.getRecipients().get(i).getFailureMsg());
            assertNull("transaction_no should be null", obj.getRecipients().get(i).getTransactionNo());
            assertTrue("fee should be greater than or equal to 0", obj.getRecipients().get(i).getFee() >= 0);
        }
    }

    @Test
    public void testReversePayment() {
        String appId = XPayTestData.getAppID();

        String pamentId = "ch_Py5SC89OyT00W5K4uHPmLCSC";

        Payment payment = null;
        try {
            // 发起 payment 撤销请求
            payment = Payment.reverse(pamentId);
            System.out.println(payment);

            assertEquals("payment object should be payment", "payment", payment.getObject());
            assertNotNull("payment reversed not null", payment.getReversed());
        } catch (XPayException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRetrieveRefund() {
        String pamentId = "ch_Ti1eD0WP08eDPSSqnTOmLWHK";
        String refundId = "re_8avPmLWrPaH8TKmXDK5KubrL";

        Refund refund = null;
        try {
            refund = Refund.retrieve(pamentId, refundId);
            System.out.println(refund);
        } catch (XPayException e) {
            e.printStackTrace();
        }

        assertEquals("refund object should be pament", "refund", refund.getObject());
        assertNotNull("refund extra not null", refund.getExtra());
    }

    @Test
    public void testRetrievePayment() {
        String paymentId = "52ef517d056d40d591aca2653bafba9e";

        Payment payment = null;
        try {
            payment = Payment.retrieve(paymentId);
            System.out.println(payment);
        } catch (XPayException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testRetrieveTransfer() {
        String paymentId = "0a6cf2488a094c2e8fc5aced13facdfc";

        Transfer transfer = null;
        try {
            transfer = Transfer.retrieve(paymentId);
            System.out.println(transfer);
        } catch (XPayException e) {
            e.printStackTrace();
        }


    }
}
