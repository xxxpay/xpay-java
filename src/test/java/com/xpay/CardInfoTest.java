package com.xpay;

import com.xpay.exception.XPayException;
import com.xpay.model.CardInfo;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CardInfoTest extends XPayTestBase {
    /**
     * 通过卡号查询卡信息。
     */
    @Test public void testCardInfoQuery() throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app", XPayTestData.getAppID());
        params.put("bank_account", "6222280012469823");

        CardInfo obj = CardInfo.query(params);

        assertEquals("622228", obj.getCardBin());
        assertEquals("0310", obj.getOpenBankCode());
        assertEquals("浦东发展银行", obj.getOpenBank());
        assertEquals(2, obj.getCardType().intValue());
    }
}
