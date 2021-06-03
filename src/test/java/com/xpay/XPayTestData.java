package com.xpay;

/**
 * Created by Afon on 2016/12/20.
 */
public class XPayTestData {
    public static String getApiBase() {
//        return "https://api-test.lucfish.com/xpay";
        return "http://127.0.0.1:10216";
    }

    public static String getApiKey() {
        return "76352e306e844d8fbe35d9b79b0d770c";
    }

    public static String getAppID() {
        return "e79d3840cf6c4a1d8654a2819985b154";
    }

    public static String getPKCS8PrivateKey() {

        return "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCkoVGs87lQ3ZF4\n" +
                "40M3C2yVbn504gRdwyhxdycq9bDI1wkuD1ebSLRgI/PGuGHA2XF5YF3dgHwTb4j+\n" +
                "Dp81tE+lLKEg1JUwyE6QOJ1FP73japfSUqGs0Ee3wc3hH6fG1xOp1xzwFmlA/Iph\n" +
                "Ja4NsMcCA4XfW/Otr+e5WtJHmDLMi/iDl12Qmrs67nj7WhVirc6nSvy/qysoko26\n" +
                "QlVK88Erqpzy9htYn1SxHhcsbW+e+OMquG7Gy5KohwhwsZ9IzDzwy/aX8xB6F8br\n" +
                "OMhiODsca23xrFhS1JBCew33IeG/IIO8B9wqYcWy/sPSBJ7c7kxAJg5F1tHCemnl\n" +
                "YJ0sZ/utAgMBAAECggEAfWUajv+9QWjiqw9/XOfotxFIZMLazIgfv/0f6krlcrTH\n" +
                "mzu4YODJ8wivX8eFPZziH69VD6gT2cH0uH5uqjtDBu6tdBI36MZJgPR+ZgadHiFM\n" +
                "rridyMGEPuTxae3wnzWnFpBwzDZlyUgSJtjKcEcb7d69E1o4iy0W9UnGLR4yYzVo\n" +
                "0JzUZODIu7n1sECddduqBbaz+NRGpTgH87VUVpp0S7c5yY6Vc7J3GYBOLpy3CDd3\n" +
                "0zEJr8kBU1+Pajk9XYf+ULeCG8AK0cn9KWgww5qOwa5An0phIor238Ce+MBeHk4R\n" +
                "GliTREl+JNmMAIwF/0WmdiVmPILrcNFVCOwYohkLyQKBgQDYf/ZGf0nM8XGYirLi\n" +
                "Sj+RfbOWlOSTqHDj4azMX3uc9GfizOjvEoTgrnw9CLOR67Xf60Cj3a6tX9bz0//H\n" +
                "ANwb1vmD7eRMTfaqpSQ3FfPT3jRAk/nHt7WIA86oRW8s+zQWCmAp8PAs1H7kcra0\n" +
                "SHT6LaHm45Qf5lNxoBldqZi9wwKBgQDCqq8V470xjHYW9tdwW2RCd+tFTn+9iQ/M\n" +
                "4nmylVa1un/HPhoPgyRgr8U6wQ0Cd1a/IQVx8E9C3X/ekevzrEtFru0nBick0sHs\n" +
                "Gb5RLF85GKufELHF3WkZhh1h9sAY2RJ5XTZZnH1uahYPDkZ800nad/T3duQtq+Ex\n" +
                "gzvlZL+ZzwKBgA1/fOVMTleevgxaqWh+ZJQ3mBjNU6r5F4C9sz5Svaw9eLSlPeiZ\n" +
                "6PrxJgHQJxHz9jTtv+v3iEp67TXqg8nufcqmjovxKwiu27Ar96QPlFIjSnK0RyBy\n" +
                "jbjbM+k92v6c8tRk9TXoNbE11mt703ROCC0I500z5ypN++nbp3k1d7ZtAoGBAJr9\n" +
                "8zFmhjhxMYTPPHFFEuqpODWSbrql6mKi32qE5OkEeMBWfcFkFQ62ZD6Hfqg8BGFh\n" +
                "FUjGoRUH7stzO35j6/qrcD7l8zyqYaRuSs2umpKHRf37+M8lnoyn77UUFZazHrZq\n" +
                "tN9cbbH/3VhXcV/pip/barutebezZjVZ29KlCLiZAoGBALXBFZruDrHSKjnviVrV\n" +
                "58oVEfsBGHGTj64aKE4dnYZTWdmhx0v3ne8hCyrJvxSdYhGFRZaLAZPd1g2A0JVa\n" +
                "zlvyIcNn/xQ8hO6L55OxUH0FqmlcwXP8bZEp9fGiML/59UOSn+vMy3O2Mc0OShrp\n" +
                "99s+ocGf/85ybWCDY5hRloiQ" +
                "\n-----END PRIVATE KEY-----";

    }

    public static String getPaymentWebhooksData() {
        return "{\"id\":\"evt_c4qfbcefvIhsxKuES4CpqdUN\",\"created\":1482204769,\"livemode\":false,\"type\":\"payment.succeeded\",\"data\":{\"object\":{\"amount\":100,\"amount_refunded\":0,\"amount_settle\":100,\"app\":\"app_1Gqj58ynP0mHeX1q\",\"body\":\"Your body\",\"channel\":\"alipay\",\"client_ip\":\"210.28.41.51\",\"created\":1482204769,\"credential\":{},\"currency\":\"cny\",\"description\":\"Description.\",\"extra\":{},\"failure_code\":null,\"failure_msg\":null,\"id\":\"ch_1SiPqPDCuvj5S4OaTSX54KC0\",\"livemode\":false,\"metadata\":{},\"object\":\"payment\",\"order_no\":\"orderno1482210036043\",\"paid\":true,\"refunded\":false,\"refunds\":{\"data\":[],\"has_more\":false,\"object\":\"list\",\"url\":\"/v2/payments/ch_1SiPqPDCuvj5S4OaTSX54KC0/refunds\"},\"subject\":\"Your Subject\",\"time_expire\":1482207768,\"time_paid\":1482204769,\"time_settle\":null,\"transaction_no\":\"2016122028818332\"}},\"object\":\"event\",\"request\":\"iar_cfgO0GxCSs9CH0K4r1t5Whjk\",\"pending_webhooks\":0}";
    }

    public static String getBatchTransferWebhooksData() {
        return "{\"id\":\"evt_cx1zsoQsiPfjagJKt5gydjsx\",\"created\":1475924802,\"livemode\":true,\"type\":\"batch_transfer.succeeded\",\"data\":{\"object\":{\"id\":\"181610081644346142\",\"amount\":2200,\"app\":\"app_1Gqj58ynP0mHeX1q\",\"batch_no\":\"battr1475916275\",\"channel\":\"alipay\",\"created\":1475916274,\"currency\":\"cny\",\"description\":\"Batch transfer description.\",\"extra\":{},\"failure_msg\":null,\"fee\":100,\"livemode\":true,\"metadata\":{},\"object\":\"batch_transfer\",\"recipients\":[{\"account\":\"test@gmail.com\",\"amount\":1100,\"description\":\"批量付款说明。\",\"name\":\"test\",\"status\":\"paid\",\"transfer\":\"tr_uj9GSfTK8G8mLeHu9KafK5WT\"},{\"account\":\"test@gmail.com\",\"amount\":1100,\"description\":\"批量付款说明。\",\"name\":\"test002\",\"status\":\"paid\",\"transfer\":\"tr_PiXiffX4mbevX5HDfT44DmjL\"}],\"status\":\"succeeded\",\"time_succeeded\":null,\"transaction_no\":null,\"type\":\"b2c\"}},\"object\":\"event\",\"request\":\"iar_23eD0xHi58zLfD5HKdnC2nDc\",\"pending_webhooks\":0}";
    }

    public static String getWithdrawalWebhooksData() {
        return "{\"id\":\"evt_gJKt5gzsoQsiPfcx1Pfjajaw\",\"created\":1475924802,\"livemode\":true,\"type\":\"balance.withdrawal.succeeded\",\"data\":{\"object\":{\"id\":\"1701611150302360654\",\"object\":\"withdrawal\",\"app\":\"app_1Gqj58ynP0mHeX1q\",\"amount\":20000,\"asset_transaction\":\"\",\"balance_transaction\":\"\",\"channel\":\"unionpay\",\"created\":1472648887,\"description\":\"test232description\",\"extra\":{\"card_number\":\"6225210207073918\",\"user_name\":\"姓名\",\"open_bank_code\":\"0102\",\"prov\":\"上海\",\"city\":\"上海\"},\"fee\":200,\"livemode\":true,\"metadata\":{},\"order_no\":\"20160829133002\",\"source\":null,\"status\":\"pending\",\"time_canceled\":null,\"time_succeeded\":null,\"user\":\"user_001\",\"user_fee\":50}},\"object\":\"event\",\"request\":\"iar_23eD0xHi58zLfD5HKdnC2nDc\",\"pending_webhooks\":0}";
    }

    public static String getAgreementEventData() {
        return "{\"created\":1526557545,\"livemode\":false,\"type\":\"agreement.succeeded\",\"data\":{\"object\":{\"id\":\"agr_19EEE7QdgGMCoY\",\"object\":\"agreement\",\"livemode\":false,\"app\":\"app_1Gqj58ynP0mHeX1q\",\"created\":1526557489,\"channel\":\"qpay\",\"contract_no\":\"2018051700001\",\"contract_id\":\"1413528914776620328305865065617065\",\"credential\":{},\"status\":\"succeeded\",\"time_succeeded\":1526557545,\"time_canceled\":null,\"failure_code\":null,\"failure_msg\":null,\"extra\":{\"display_account\":\"签约测试\"},\"metadata\":{}}},\"object\":\"event\",\"request\":\"iar_L08SS8iLCubTLi10yDrbP4a5\",\"scope\":\"app_1Gqj58ynP0mHeX1q\",\"acct_id\":\"acct_zjb1KS1i9C0CvzrL\"}";
    }

    public static String getRechargeSucceededEventData() {
        return "{\"id\":\"evt_400180517202605018219403\",\"created\":1526559964,\"livemode\":false,\"type\":\"recharge.succeeded\",\"data\":{\"object\":{\"id\":\"220180517753149716480010\",\"object\":\"recharge\",\"app\":\"app_1Gqj58ynP0mHeX1q\",\"created\":1526559949,\"livemode\":false,\"amount\":90,\"succeeded\":true,\"time_succeeded\":1526559964,\"refunded\":false,\"user\":\"user_test_02\",\"from_user\":\"user_test_02\",\"user_fee\":10,\"payment\":{\"id\":\"ch_0u9erLv9WPeD48WX14i9SebP\",\"object\":\"payment\",\"created\":1526559949,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_1Gqj58ynP0mHeX1q\",\"channel\":\"alipay_wap\",\"order_no\":\"20171526559948047\",\"client_ip\":\"127.0.0.1\",\"amount\":100,\"amount_settle\":100,\"currency\":\"cny\",\"subject\":\"Recharge subject\",\"body\":\"Recharge body\",\"extra\":{\"success_url\":\"http://www.xpay.com\",\"buyer_account\":\"alipay_account\"},\"time_paid\":1526559964,\"time_expire\":1526646349,\"time_settle\":null,\"transaction_no\":\"2018051714482272\",\"refunds\":{\"object\":\"list\",\"url\":\"/v2/payments/ch_0u9erLv9WPeD48WX14i9SebP/refunds\",\"has_more\":false,\"data\":[]},\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":\"Recharge description.\"},\"balance_bonus\":null,\"balance_transaction\":\"600180517753305323520001\",\"description\":\"Recharge description.\",\"metadata\":{}}},\"object\":\"event\",\"request\":\"iar_nbrfrD4en14GrbTirLnfHOC8\",\"pending_webhooks\":0}";
    }

    public static String getOrderSucceededEventData() {
        return "{\"id\":\"evt_400180517202836018305903\",\"created\":1526560116,\"livemode\":false,\"type\":\"order.succeeded\",\"data\":{\"object\":{\"id\":\"2001805170000308581\",\"object\":\"order\",\"created\":1526560047,\"livemode\":false,\"paid\":true,\"refunded\":false,\"status\":\"paid\",\"app\":\"app_1Gqj58ynP0mHeX1q\",\"uid\":\"test_user_001\",\"available_balance\":4,\"merchant_order_no\":\"20171526560045673\",\"amount\":100,\"actual_amount\":100,\"amount_refunded\":0,\"amount_paid\":100,\"coupon_amount\":0,\"currency\":\"cny\",\"subject\":\"ORDER_SUBJECT\",\"body\":\"ORDER_BODY\",\"client_ip\":\"192.168.1.125\",\"time_paid\":1526560116,\"time_expire\":1526646447,\"payment\":\"ch_5iTOm1P8inv1L48iL4bTOyLS\",\"coupon\":null,\"description\":null,\"metadata\":{},\"payment_essentials\":{\"channel\":\"alipay_wap\",\"transaction_no\":\"2018051773981055\",\"failure_code\":null,\"failure_msg\":null,\"extra\":{\"success_url\":\"http://www.xpay.com\",\"buyer_account\":\"alipay_account\"},\"credential\":{}},\"receipt_app\":\"app_1Gqj58ynP0mHeX1q\",\"service_app\":\"app_1Gqj58ynP0mHeX1q\",\"available_methods\":[],\"payments\":{\"object\":\"list\",\"url\":\"/v2/payments\",\"has_more\":false,\"data\":[{\"id\":\"ch_5iTOm1P8inv1L48iL4bTOyLS\",\"object\":\"payment\",\"created\":1526560093,\"livemode\":false,\"paid\":true,\"refunded\":false,\"reversed\":false,\"app\":\"app_1Gqj58ynP0mHeX1q\",\"channel\":\"alipay_wap\",\"order_no\":\"20171526560045673\",\"client_ip\":\"192.168.1.125\",\"amount\":100,\"amount_settle\":0,\"currency\":\"cny\",\"subject\":\"ORDER_SUBJECT\",\"body\":\"ORDER_BODY\",\"extra\":{\"success_url\":\"http://www.xpay.com\",\"buyer_account\":\"alipay_account\"},\"time_paid\":1526560116,\"time_expire\":1526646447,\"time_settle\":null,\"transaction_no\":\"2018051773981055\",\"refunds\":null,\"amount_refunded\":0,\"failure_code\":null,\"failure_msg\":null,\"metadata\":{},\"credential\":{},\"description\":null}]}}},\"object\":\"event\",\"request\":\"iar_bXrXH0ib9yT4vLuDmLrDmb5K\",\"pending_webhooks\":0}";
    }
}
