package com.xpay.example;

import com.xpay.XPay;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 */
public class Main {
    /**
     * XPay 管理平台对应的 API Key，api_key 获取方式：登录 [Dashboard](https://dashboard.xpay.com)->点击管理平台右上角公司名称->开发信息-> Secret Key
     */
    private final static String apiKey = "3d6285c77d1646f096c21210f9a6db22";

    /**
     * XPay 管理平台对应的应用 ID，app_id 获取方式：登录 [Dashboard](https://dashboard.xpay.com)->点击你创建的应用->应用首页->应用 ID(App ID)
     */
    private final static String appId = "f5fe7e65ad7f46af89921565f78a9879";

    /**
   * 设置请求签名密钥，密钥对需要你自己用 openssl 工具生成，如何生成可以参考帮助中心：https://help.xpay.com/article/123161；
   * 生成密钥后，需要在代码中设置请求签名的私钥(rsa_private_key.pem)；
   * 然后登录 [Dashboard](https://dashboard.xpay.com)->点击右上角公司名称->开发信息->商户公钥（用于商户身份验证）
   * 将你的公钥复制粘贴进去并且保存->先启用 Test 模式进行测试->测试通过后启用 Live 模式
   */

    // 你生成的私钥路径
    private final static String privateKeyFilePath = "res/your_rsa_private_key_pkcs8.pem";

    protected static String projectDir;

    public static void main(String[] args) throws Exception {
        projectDir = System.getProperty("user.dir") + "/example/";

        XPay.setApiBase("https://api.xpay-test.lucfish.com");

        // 设置 API Key
        XPay.apiKey = apiKey;

        XPay.appId = appId;

        // 设置私钥路径，用于请求签名
//        XPay.privateKeyPath = privateKeyFilePath;

        /**
         * 或者直接设置私钥内容
         XPay.privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
         "... 私钥内容字符串 ...\n" +
         "-----END RSA PRIVATE KEY-----\n";
         */
        XPay.privateKey = "-----BEGIN PRIVATE KEY-----\n" +
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCvcAdGfHbKiK5g\n" +
                "51jichWb2boBOtC24HjwzqW9EWwqtRxJ8QUBZSj16XsdMvd09SYApNhqcWNk+3ow\n" +
                "baQuQmZOMFQA4t3IRebwWUdnTHx1trCkYz9/JxTvzUSCdiRotGdk5d9lGW88uv5L\n" +
                "RXXahsTOgHCBFtM1jUWv2nC4r5udluEpjHj852nuhdEil0TwOe5w+ML4qUQdhot3\n" +
                "SXFeGOlzM0hSUc1N0AUh7nfPwBIG0py+t8tcw7KzdCHydCllMxpeVNnOFCrymYaD\n" +
                "xQFn/iItTzO5CRHhiahlv8FOpwhBWpH/OAqPtpECtX1AkxvF1HYwTO0qZaMp5T7b\n" +
                "XQCg8X1hAgMBAAECggEAKayjDctjLJlrUvmh06jmGS+PT9t42PhZwlpUZKVO3JZJ\n" +
                "Mgde+QXexQvBgx4oSlAxxtVh02c8BTD3xalF5vc+9jPkwJEjvf9c7JtIqvEwX4YW\n" +
                "T/aDjuDpyE0qiRMncvfn18ADYTC5i+OfpKHLbS22cpdwIjoZ0g7NDwkE3dpZTQW1\n" +
                "l2XinS5lcwAUnESmykCKPiwwrO7CDgj2zc+CCQBatYOIV7EMKq1VlAdYXuAYlKXE\n" +
                "/RhzJnlwXMcZpVRcUM0W21SLK6Mn4GY8jJtimSHAcsHqVQGHSOPuWXlXPgHtUau+\n" +
                "rcw6VBd+9pjF6y5VoG0HwJsii7iBv9PY1bXJapcvQQKBgQDblYaHEPunM3yHqIp+\n" +
                "I5x36MojfLAJ2YHeb5dGtm8KA+6chS5kUXtbfv/ftxCy/lS0zCdTnnaNhvcDSTOs\n" +
                "vsYXPF+/QE/5U540C+YVwzfpl1LmGikepJUvdxJGQUePRfcO2ZV/01wgaunOPunK\n" +
                "n11fKj4mUYPjytXidBYRKBgDPwKBgQDMiEIH+MvhwP8p9t81lYGABl28zUgs5m9q\n" +
                "ndMOoEHiwizDjyeOaq2WaE95vLj7w9lOxiRT+puzaSSce8SJuGzi5UGPXm9qp/VS\n" +
                "KIvK8crMo6DKeyknbKfKRiouGudPnZMg2jU4YQa4+lUUwzxg9PU+yox9EL2+celU\n" +
                "4R3n1fp3XwKBgBNE2MxLcjnm67ufz59oEpf3Jp3cmDoVCy9wzW6YHcBcPfkgOsT0\n" +
                "3YVW7K8+CkoaxWYkMCNHWZHr0QtJxi4Xg5yQYLqQszPm4ZAhpywruGFYNR8aFpeo\n" +
                "y6qhoUnm+peZBSgZceQIsSHrH99IaA2u1GvAcjm8l31K1GAN3c3dndXTAoGAYgH5\n" +
                "AjDqIaeFneo6U0bs4xgp2srThxB02zX9aMjKSYqaQKtcXRYpUCVzz/Xq/ll+zAyO\n" +
                "Y992tKXxcTqtlwDUzHTm0XiDEyyglVnwgrMSZrUR23Tg549dZ8PvemBR7wim89sc\n" +
                "HYQA4Kq0Elrrl9pJmmkcoOFgyt1y3cVxuyIB/ykCgYEA07DlFU8mRByLFmutQt/n\n" +
                "JHdcrC2uxLUQhCPDknIw+kbHcRhzH7ZzSTS9vMm5emyrv+7U71Z3zqXKn3Va8Cd1\n" +
                "cwIvTp6xDmMrwiZuziFBDQaGJmQu038psjPUSf253LLRtxwPY9m8a2sLIL9dghwh\n" +
                "8r2h74U8ScCKLhG0enrYi30=\n" +
                "-----END PRIVATE KEY-----";


        // Payment 示例
        PaymentExample.runDemos(appId);

        // Refund 示例
        RefundExample.runDemos();

        // RedEnvelope 示例
        RedEnvelopeExample.runDemos(appId);

        // Transfer 示例
        TransferExample.runDemos(appId);

        // Event 示例
        EventExample.runDemos();

        // Webhooks 验证示例
        WebhooksVerifyExample.runDemos();

        // 微信公众号 openid 相关示例
        WxPubOAuthExample.runDemos(appId);

        // 身份证银行卡信息认证接口
        // 请使用 live key 调用该接口
        // IdentificationExample.runDemos(appId);

        // 批量付款示例
        BatchTransferExample.runDemos(appId);

        // 报关
        // 请使用 live key 调用该接口
        CustomsExample.runDemos(appId);
    }

    private static SecureRandom random = new SecureRandom();

    public static String randomString(int length) {
        String str = new BigInteger(130, random).toString(32);
        return str.substring(0, length);
    }

    public static int currentTimeSeconds() {
        return (int)(System.currentTimeMillis() / 1000);
    }
}
