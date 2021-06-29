package com.xpay.order;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.Royalty;
import com.xpay.model.RoyaltyCollection;
import com.xpay.model.RoyaltyDataResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoyaltyTest extends XPayTestBase {
    /**
     * 批量更新 royalty
     */
    @Test
    public void testRoyaltyBatchUpdate() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        List<String> ids = new ArrayList<>(); // 分润 ID 列表, 必传
        ids.add("53647748403200");
        params.put("ids", ids);
        params.put("method", "manual");     // 手动标记结算: manual 或 取消手动标记结算：null, 可选
        params.put("description", "royalty batch update description"); // 描述, 可选
        // 批量更新 royalty 方法
        // 参数: params
        RoyaltyCollection objs = Royalty.batchUpdate(params);
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 查询 royalty
     */
    @Test public void testRoyaltyRetrieve() throws XPayException {
        // 查询 royalty 方法
        // 参数: royalty id
        Royalty obj = Royalty.retrieve("53647748403200");
        System.out.println(obj);

        assertEquals("object should be royalty", "royalty", obj.getObject());
    }

    /**
     * 查询 royalty list
     */
    @Test public void testRoyaltyList() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("per_page", 30);  // 可选
        params.put("page", 1);      // 可选
//        params.put("royalty_settlement", null);  // 可选 关联的分润结算 ID
//        params.put("royalty_transaction", null); // 可选 关联的分润结算明细 ID
//        params.put("payer_app", XPayTestData.getAppID());      // 可选
//        params.put("recipient_app", XPayTestData.getAppID());      // 可选
//        params.put("source_app", XPayTestData.getAppID());      // 可选
//        params.put("source_no", "20171624691382721");      // 可选

        List source_nos = new ArrayList<String>();
        source_nos.add("20171624691382721");
        source_nos.add("20171624691382722");
//        params.put("source_nos", source_nos);      // 可选
//        params.put("source_user", "user_test_02royalty_1");      // 可选

        // 值为 created：入账、pending：结算发起、waiting：结算汇总、succeeded：结算成功
//        params.put("status", "succeeded");      // 可选
        params.put("created[gt]", 1624691519000L);
//        params.put("created[gte]", 1624691519000L);
//        params.put("created[lt]", 1624691519000L);
//        params.put("created[lte]", 1624691519000L);
        // 查询 royalty list 列表方法
        // 参数: params
        RoyaltyCollection objs = Royalty.list(params);
        System.out.println(objs.getData().size());
        System.out.println(objs);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 创建分润
     */
    @Test public void testRoyaltyDataCreate() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", XPayTestData.getAppID()); // 必传
//        params.put("payment", ""); // 条件可选，对于已经成功的 order 必传该字段
        List<Map<String, Object>> royaltyUsers = new ArrayList<>();
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("user", "U201908030002");
        user.put("amount", 1);
        royaltyUsers.add(user);
        params.put("royalty_users", royaltyUsers); // 可选 分润的用户信息列表，默认为[]，不分润。

        String orderId = "2011909040000002881";
        RoyaltyDataResult result = Royalty.createData(orderId, params);

        assertTrue("succeeded", result.getSucceeded());
        assertEquals("app should be the same", XPayTestData.getAppID(), result.getApp());
        assertEquals("order ID should returned as the same", orderId, result.getOrder());
    }
}
