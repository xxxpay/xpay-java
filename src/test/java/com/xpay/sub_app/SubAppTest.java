package com.xpay.sub_app;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.DeletedSubApp;
import com.xpay.model.SubApp;
import com.xpay.model.SubAppCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SubAppTest extends XPayTestBase {
    /**
     * 创建子商户 app
     */
    @Test
    public void testSubAppCreate() throws XPayException {
        String userId = "sub_app_user_" + System.currentTimeMillis();
        String displayName = "sub_app_" + System.currentTimeMillis();

        Map<String, Object> params = new HashMap<>();
        params.put("user", userId);
        params.put("display_name", displayName);
        params.put("parent_app", XPayTestData.getAppID()); //父商户应用 ID，必须为平台或者平台下其他的子商户，默认值为平台

        // 创建子商户 app 方法
        // 参数: params
        SubApp obj = SubApp.create(params);
        System.out.println(obj);

        assertEquals("object should be sub_app", "sub_app", obj.getObject());
        assertEquals("user", userId, obj.getUser());
        assertEquals("display_name", displayName, obj.getDisplayName());
    }

    /**
     * 查询子商户 app
     */
    @Test public void testSubAppRetrieve() throws XPayException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        // 查询子商户 app
        // 参数: SubApp id
        SubApp obj = SubApp.retrieve(subAppId);

        assertEquals("object should be sub_app", "sub_app", obj.getObject());
        assertEquals("id", subAppId, obj.getId());
    }

    /**
     * 查询子商户 app 列表
     */
    @Test public void testSubAppList() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
        // 查询子商户 app 列表方法
        // 参数: params
        SubAppCollection objs = SubApp.list(params);

        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 更新子商户 app
     */
    @Test public void testSubAppUpdate() throws XPayException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        Map<String, Object> params = new HashMap<>();
        // 更新子商户 app 方法
        // 参数一: SubApp id
        // 参数二: params
        SubApp obj = SubApp.update(subAppId, params);

        assertEquals("object should be sub_app", "sub_app", obj.getObject());
    }

    /**
     * 删除子商户 app
     */
    @Test public void testSubAppDelete() throws XPayException {
        String subAppId = "app_rbDmXLHmLqbTLKm9";
        // 删除子商户 app 方法
        // 参数: SubApp id
        DeletedSubApp obj = SubApp.delete(subAppId);

        assertEquals("id", subAppId, obj.getId());
    }
}
