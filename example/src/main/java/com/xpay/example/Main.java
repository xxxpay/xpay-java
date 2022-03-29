package com.xpay.example;

import com.xpay.XPay;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;

/**
 */
public class Main {
    /**
   * 设置请求签名密钥，密钥对需要你自己用 openssl 工具生成，如何生成可以参考帮助中心：https://help.xpay.lucfish.com/article/123161；
   * 生成密钥后，需要在代码中设置请求签名的私钥(rsa_private_key.pem)；
   * 然后登录 [Dashboard](https://dashboard.xpay.lucfish.com)->点击右上角公司名称->开发信息->商户公钥（用于商户身份验证）
   * 将你的公钥复制粘贴进去并且保存->先启用 Test 模式进行测试->测试通过后启用 Live 模式
   */

    // 你生成的私钥路径
    private final static String privateKeyFilePath = "res/your_rsa_private_key_pkcs8.pem";

    protected static String projectDir;

    public static void main(String[] args) throws Exception {
        projectDir = System.getProperty("user.dir") + "/example/";

        Properties props = PropertyUtil.loadProps(projectDir + "res/xpay.properties");
        if (props.containsKey("api_base")) {
            XPay.setApiBase(props.getProperty("api_base"));
        }

        // 设置 API Key
        XPay.apiKey = props.getProperty("api_key");
        XPay.appId = props.getProperty("app_id");

        // 设置私钥，用于请求签名
        XPay.privateKey = FileUtil.getStringFromFile(Main.projectDir + props.getProperty("private_key_path"));

        // Payment 示例
        PaymentExample.runDemos(XPay.appId);
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
