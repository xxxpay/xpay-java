package com.xpay.order;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.DeleteRoyaltyTemplate;
import com.xpay.model.RoyaltyTemplate;
import com.xpay.model.RoyaltyTemplateCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoyaltyTemplateTest extends XPayTestBase {
    /**
     * 创建 royalty_template
     */
    @Test
    public void testRoyaltyTemplateCreate() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", XPayTestData.getAppID()); // App ID, 必传
        params.put("name", "royalty_templates name"); // 模板名称，允许中英文等常用字符, 可选

        Map<String, Object> rule = new HashMap<>();
        rule.put("royalty_mode", "rate"); // 分润模式。分为按订单金额（包含优惠券金额）的比例 rate 和固定金额 fixed, 必传
        rule.put("refund_mode", "proportional"); // 退分润模式。分为退款时不退分润 no_refund、按比例退分润 proportional 和一旦退款分润全退 full_refund, 必传
        // 分配模式。指当订单确定的层级如果少于模板配置层级时，模板中多余的分润金额是归属于收款方 receipt_reserved 还是服务方 service_reserved。
        // 必传
        rule.put("allocation_mode", "receipt_reserved");

        List<Map> data = new ArrayList<>(); // 分润数据列表, 必传
        Map<String, Object> data1 = new HashMap<>();
        data1.put("level", 0);  // 子商户层级值，0 表示平台， 1 表示一级子商户，取值范围 >=0
        data1.put("value", 5000); // 分润数值。rate 下取值为 0 - 10000，单位为 0.01 %，fixed 下取值为 0 - 1000000，单位为分
        Map<String, Object> data2 = new HashMap<>();
        data2.put("level", 1);
        data2.put("value", 5000);
        Map<String, Object> data3 = new HashMap<>();
        data3.put("level", 2);
        data3.put("value", 5000);
        Map<String, Object> data4 = new HashMap<>();
        data4.put("level", 3);
        data4.put("value", 5000);
        Map<String, Object> data5 = new HashMap<>();
        data5.put("level", 4);
        data5.put("value", 5000);
        Map<String, Object> data6 = new HashMap<>();
        data6.put("level", 5);
        data6.put("value", 5000);
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);
        data.add(data5);
        data.add(data6);

        rule.put("data", data);
        params.put("rule", rule);

        // 创建 royalty_template 方法
        // 参数: params
        RoyaltyTemplate obj = RoyaltyTemplate.create(params);
        System.out.println(obj);
        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
        assertEquals("name", params.get("name"), obj.getName());
    }

    /**
     * 查询单个 royalty_template
     */
    @Test public void testRoyaltyTemplateRetrieve() throws XPayException {
        String id = "53652865716224";
        // 查询单个 royalty_template 方法
        // 参数: royalty_template id
        RoyaltyTemplate obj = RoyaltyTemplate.retrieve(id);
        System.out.println(obj);
        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
        assertEquals("id", id, obj.getId());
    }

    /**
     * 查询 royalty_template 列表
     */
    @Test public void testRoyaltyTemplateList() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("per_page", 3);
        params.put("page", 1);
        params.put("app", XPayTestData.getAppID());
        // fixed
        params.put("rule[royalty_mode]", "rate");
        // proportional full_refund no_refund
        params.put("rule[refund_mode]", "no_refund");
        // service_reserved receipt_reserved
//        params.put("rule[allocation_mode]", "receipt_reserved");
        params.put("created[gt]", 1624627383000L);
//        params.put("created[gte]", 1624627415000L);
        params.put("created[lt]", 1624627415000L);
//        params.put("created[lte]", 1624627383000L);
        // 查询 royalty_template list 列表方法
        // 参数: params
        RoyaltyTemplateCollection objs = RoyaltyTemplate.list(params);
        System.out.println(objs);
        assertEquals("object should be list", "list", objs.getObject());
    }

    /**
     * 删除 royalty_template
     */
    @Test public void testRoyaltyTemplateDelete() throws XPayException {
        String id = "53652865716224";
        // 删除 royalty_template 方法
        // 参数: royalty_template id
        DeleteRoyaltyTemplate obj = RoyaltyTemplate.delete(id);
        System.out.println(obj);
        assertEquals("id", id, obj.getId());
    }

    /**
     *  更新 royalty_template
     */
    @Test public void testRoyaltyTemplateUpdate() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "royalty_templates name new");

        Map<String, Object> rule = new HashMap<>();
        rule.put("royalty_mode", "rate");
        rule.put("refund_mode", "no_refund");
        rule.put("allocation_mode", "receipt_reserved");

        List<Map> data = new ArrayList<>();
        Map<String, Object> data1 = new HashMap<>();
        data1.put("level", 0);
        data1.put("value", 11);
        Map<String, Object> data2 = new HashMap<>();
        data2.put("level", 1);
        data2.put("value", 12);
        data.add(data1);
        data.add(data2);

        rule.put("data", data);
        params.put("rule", rule);
        RoyaltyTemplate obj = RoyaltyTemplate.update("53652865716224", params);
        System.out.println(obj);
        assertEquals("object should be royalty_template", "royalty_template", obj.getObject());
    }
}
