package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.List;
import java.util.Map;

public class BatchRefund extends APIResource {
    String id;
    String object;
    String app;
    String batchNo;
    Long created;
    String description;
    Boolean livemode;
    Map<String, Object> metadata;
    List<BatchRefundPayments> payments;
    PaymentRefundCollection refunds;
    String refundUrl;
    String status;
    Long timeSucceeded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<BatchRefundPayments> getPayments() {
        return payments;
    }

    public void setPayments(List<BatchRefundPayments> payments) {
        this.payments = payments;
    }

    public PaymentRefundCollection getRefunds() {
        return refunds;
    }

    public void setRefunds(PaymentRefundCollection refunds) {
        this.refunds = refunds;
    }

    public String getRefundUrl() {
        return refundUrl;
    }

    public void setRefundUrl(String refundUrl) {
        this.refundUrl = refundUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeSucceeded() {
        return timeSucceeded;
    }

    public void setTimeSucceeded(Long timeSucceeded) {
        this.timeSucceeded = timeSucceeded;
    }

    /**
     * @param clazz
     * @return String
     */
    protected static String classURL(Class<?> clazz) {
        return apiBasePrefixedURL("/v2/batch_refunds");
    }

    /**
     * 创建 batch_refund
     *
     * @param params
     * @return BatchRefund
     * @throws XPayException
     */
    public static BatchRefund create(Map<String, Object>params)
            throws XPayException {
        return create(params, null);
    }

    /**
     * 创建 batch_refund
     *
     * @param params
     * @param options the specific options
     * @return BatchRefund
     * @throws XPayException
     */
    public static BatchRefund create(Map<String, Object>params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(BatchRefund.class), params, BatchRefund.class, options);
    }

    /**
     * 查询 batch_refund
     *
     * @param id
     * @return BatchRefund
     * @throws XPayException
     */
    public static BatchRefund retrieve(String id)
            throws XPayException {
        return retrieve(id, null);
    }

    /**
     * 查询 batch_refund
     *
     * @param id
     * @param options the specific options
     * @return BatchRefund
     * @throws XPayException
     */
    public static BatchRefund retrieve(String id, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(BatchRefund.class, id), null, BatchRefund.class, options);
    }

    /**
     * 查询 batch_refund 列表
     *
     * @param params
     * @return BatchRefundCollection
     * @throws XPayException
     */
    public static BatchRefundCollection list(Map<String, Object> params)
            throws XPayException {
        return list(params, null);
    }

    /**
     * 查询 batch_refund 列表
     *
     * @param params
     * @param options the specific options
     * @return BatchRefundCollection
     * @throws XPayException
     */
    public static BatchRefundCollection list(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(BatchRefund.class), params, BatchRefundCollection.class, options);
    }
}
