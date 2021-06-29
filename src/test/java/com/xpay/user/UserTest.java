package com.xpay.user;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.User;
import com.xpay.model.UserCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * @author Afon, @date 17-03-28
 */
public class UserTest extends XPayTestBase {

    /**
     * 创建用户 (User)
     */
    @Test public void testUserCreate() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", XPayTestData.userId + "_05"); // 用户 ID，首字母必须是英文数字或者 _-@, 必传
        params.put("address", "Shanghai, China");       // 用户地址, 可选
        params.put("avatar", "https://example.com/avatar.png"); // 头像, 可选
        params.put("email", params.get("id") + "@gmail.com");   // 邮箱地址, 可选
        params.put("gender","MALE"); // 性别。MALE：男，FEMALE：女, 可选
        params.put("mobile", "17602101010");    // 手机号码, 可选
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("custom_key", "custom_value");
        params.put("metadata", metadata);

        User obj = User.create(params); //创建 User 方法

        System.out.println(obj);

        assertEquals("object should be user", "user", obj.getObject());
        assertEquals("id", params.get("id"), obj.getId());
        assertEquals("app", XPayTestData.getAppID(), obj.getApp());
        assertEquals("address", params.get("address"), obj.getAddress());
        assertEquals("avatar", params.get("avatar"), obj.getAvatar());
        assertEquals("email", params.get("email"), obj.getEmail());
        assertEquals("gender", params.get("gender"), obj.getGender());
        assertEquals("mobile", params.get("mobile"), obj.getMobile());
        assertEquals("available_coupons", 0, obj.getAvailableCoupons().intValue());
        assertEquals("available_balance", 0, obj.getAvailableBalance().intValue());
        assertEquals("withdrawable_balance", 0, obj.getWithdrawableBalance().intValue());
        assertEquals("disabled", false, obj.getDisabled());
    }

    /**
     * 查询单个用户 (User)
     */
    @Test public void testUserRetrieve() throws XPayException {
        String userId = XPayTestData.userId;
        userId = "user_test_02royalty_1";
        User obj = User.retrieve(userId); //查询 User 方法

        System.out.println(obj);
        assertEquals("object should be user", "user", obj.getObject());
        assertEquals("id", userId, obj.getId());
        assertEquals("app", XPayTestData.getAppID(), obj.getApp());
    }

    /**
     * 查询用户列表 (User)
     */
    @Test public void testUserList() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("page", 1);
        params.put("per_page", 3);
//        params.put("created[gt]", 1624370410000L);
//        params.put("created[gte]", 1624369585000L);
//        params.put("created[lte]", 1624369585000L);
//        params.put("created[lt]", 1624369585000L);
        params.put("disabled", false);
        params.put("identified", false);
//        params.put("type", 0);

        UserCollection objs = User.list(params); //查询 User 列表方法
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 更新用户信息 (User)
     */
    @Test public void testUserUpdate() throws XPayException {
        String userId = XPayTestData.userId;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("address", "China, China");
        params.put("avatar", "https://example.com/avatar.png");
        params.put("email", params.get("id") + "@123.com");
        params.put("gender", System.currentTimeMillis() % 2 == 1 ? "MALE" : "FEMALE");
        params.put("mobile", "111");
        Map<String, Object> metadata = new HashMap<String, Object>();
        metadata.put("custom_key", "custom_value");
        params.put("metadata", metadata);

        User obj = User.update(userId, params); //更新 User 方法
        System.out.println(obj);
        assertEquals("object should be user", "user", obj.getObject());
        assertEquals("id", userId, obj.getId());
        assertEquals("app", XPayTestData.getAppID(), obj.getApp());
        assertEquals("address", params.get("address"), obj.getAddress());
        assertEquals("avatar", params.get("avatar"), obj.getAvatar());
        assertEquals("email", params.get("email"), obj.getEmail());
        assertEquals("gender", params.get("gender"), obj.getGender());
        assertEquals("mobile", params.get("mobile"), obj.getMobile());
        assertEquals("disabled", false, obj.getDisabled());
    }
}
