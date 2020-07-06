package com.xpay.split;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.*;
import com.xpay.model.DeletedSplitReceiver;
import com.xpay.model.SplitReceiver;
import com.xpay.model.SplitReceiverCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SplitReceiverTest extends XPayTestBase {
    @Test public void testCreate() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", XPayTestData.getAppID());
        params.put("type", "MERCHANT_ID"); // 分账接收方类型
        params.put("name", "示例商户全称"); // 分账接收方全称
        params.put("account", "190001001"); // 分账接收方帐号
        params.put("channel", "wx_pub"); // 创建分账接收方使用的渠道(参数)
        SplitReceiver obj  = SplitReceiver.create(params);

        System.out.println(obj);

        assertEquals("split_receiver", obj.getObject());
    }

    @Test public void testListAll() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", XPayTestData.getAppID());
        params.put("page", 1);
        params.put("per_page", 3);
        SplitReceiverCollection obj = SplitReceiver.list(params);

        System.out.println(obj);

        assertEquals("list", obj.getObject());
        assertEquals("split_receiver", obj.getData().get(0).getObject());
    }

    @Test public void testRetrieve() throws XPayException {
        SplitReceiver obj  = SplitReceiver.retrieve("recv_1fRc57XpIehmFI");

        System.out.println(obj);

        assertEquals("split_receiver", obj.getObject());
    }

    @Test public void testDelete() throws XPayException {
        DeletedSplitReceiver obj  = SplitReceiver.delete("recv_1fRc57XpIehmFI");

        System.out.println(obj);

        assertEquals(true, obj.getDeleted());
        assertEquals("recv_1fRc57XpIehmFI", obj.getId());
    }
}
