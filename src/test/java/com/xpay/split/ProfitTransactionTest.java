package com.xpay.split;

import com.xpay.XPayTestBase;
import com.xpay.XPayTestData;
import com.xpay.exception.XPayException;
import com.xpay.model.ProfitTransaction;
import com.xpay.model.ProfitTransactionCollection;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProfitTransactionTest extends XPayTestBase {

    @Test public void testListAll() throws XPayException {
        Map<String, Object> params = new HashMap<>();
        params.put("app", XPayTestData.getAppID());
        params.put("page", 1);
        params.put("per_page", 3);
        ProfitTransactionCollection obj = ProfitTransaction.list(params);

        System.out.println(obj);

        assertEquals("list", obj.getObject());
        assertEquals("profit_transaction", obj.getData().get(0).getObject());
    }

    @Test public void testRetrieve() throws XPayException {
        ProfitTransaction obj  = ProfitTransaction.retrieve("ptxn_1m3xtoBMRqu2qC");

        System.out.println(obj);

        assertEquals("profit_transaction", obj.getObject());
    }
}
