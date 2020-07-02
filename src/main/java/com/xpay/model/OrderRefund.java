package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.Map;

public class OrderRefund extends APIResource {

    /**
     * 创建 order_refund
     *
     * @param orderId
     * @param params
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection create(String orderId, Map<String, Object> params)
            throws XPayException {
        return create(orderId, params, null);
    }

    /**
     * 创建 order_refund
     *
     * @param orderId
     * @param params
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection create(String orderId, Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/order_refunds", instanceURL(Order.class, orderId)),
                params, OrderRefundCollection.class, options);
    }

    /**
     * 查询 order_refund
     *
     * @param orderId
     * @param refundId
     * @return Refund
     * @throws XPayException
     */
    public static Refund retrieve(String orderId, String refundId)
            throws XPayException {
        return retrieve(orderId, refundId, null);
    }

    /**
     * 查询 order_refund
     *
     * @param orderId
     * @param refundId
     * @param options the specific options
     * @return Refund
     * @throws XPayException
     */
    public static Refund retrieve(String orderId, String refundId, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/order_refunds/%s", instanceURL(Order.class, orderId), refundId),
                null, Refund.class, options);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param params
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection list(String orderId, Map<String, Object>params)
            throws XPayException {
        return list(orderId, params, null);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection list(String orderId)
            throws XPayException {
        return list(orderId, null, null);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection list(String orderId, RequestOptions options)
            throws XPayException {
        return list(orderId, null, options);
    }

    /**
     * 查询 order_refund 列表
     *
     * @param orderId
     * @param params
     * @param options the specific options
     * @return OrderRefundCollection
     * @throws XPayException
     */
    public static OrderRefundCollection list(String orderId, Map<String, Object>params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/order_refunds", instanceURL(Order.class, orderId)),
                params, OrderRefundCollection.class, options);
    }
}
