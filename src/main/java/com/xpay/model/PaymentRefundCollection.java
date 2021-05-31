package com.xpay.model;

import com.xpay.XPay;
import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.Map;

public class PaymentRefundCollection extends XPayCollectionAPIResource<Refund> {

    public PaymentRefundCollection list(Map<String, Object> params)
            throws XPayException {

        return list(params, null);
    }

    public PaymentRefundCollection list(Map<String, Object> params, RequestOptions options)
            throws XPayException {

        String url = String.format("%s%s", XPay.getApiBase(), this.getURL());
        return APIResource.request(APIResource.RequestMethod.GET, url, params, PaymentRefundCollection.class, options);
    }

    public Refund retrieve(String id)
            throws XPayException {

        return retrieve(id, null);
    }

    public Refund retrieve(String id, RequestOptions options)
            throws XPayException {

        String url = String.format("%s%s/%s", XPay.getApiBase(), this.getURL(), id);
        return APIResource.request(APIResource.RequestMethod.GET, url, null, Refund.class, options);
    }

    public Refund create(Map<String, Object> params)
            throws XPayException {

        return create(params, null);
    }

    public Refund create(Map<String, Object> params, RequestOptions options)
            throws XPayException {

        String url = String.format("%s%s", XPay.getApiBase(), this.getURL());
        return APIResource.request(APIResource.RequestMethod.POST, url, params, Refund.class, options);
    }

}
