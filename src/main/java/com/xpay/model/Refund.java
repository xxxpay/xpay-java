package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.Map;

public class Refund extends APIResource {
    String id;
    String object;
    String orderNo;
    Integer amount;
    Long created;
    Boolean succeed;
    String status;
    Long timeSucceed;
    String description;
    String failureCode;
    String failureMsg;
    Map<String, Object> metadata;
    String payment;
    String paymentOrderNo;
    String transactionNo;
    String fundingSource;
    Map<String, Object> extra;

    public String getInstanceURL() {
        if (this.payment != null) {
            return String.format("%s/%s/refunds/%s", classURL(Payment.class), this.payment, this.getId());
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public Long getTimeSucceed() {
        return timeSucceed;
    }

    public void setTimeSucceed(Long timeSucceed) {
        this.timeSucceed = timeSucceed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailureMsg() {
        return failureMsg;
    }

    public void setFailureMsg(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getPaymentOrderNo() {
        return paymentOrderNo;
    }

    public void setPaymentOrderNo(String paymentOrderNo) {
        this.paymentOrderNo = paymentOrderNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    /**
     * 创建 refund
     *
     * @param paymentId
     * @param params
     * @return Refund
     * @throws XPayException
     */
    public static Refund create(String paymentId, Map<String, Object> params)
            throws XPayException {
        return create(paymentId, params, null);
    }

    /**
     * 创建 refund
     *
     * @param paymentId
     * @param params
     * @param options the specific options
     * @return Refund
     * @throws XPayException
     */
    public static Refund create(String paymentId, Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/refunds", instanceURL(Payment.class, paymentId)),
                params, Refund.class, options);
    }

    /**
     * 查询 refund
     *
     * @param paymentId
     * @param id
     * @return Refund
     * @throws XPayException
     */
    public static Refund retrieve(String paymentId, String id)
            throws XPayException {
        return retrieve(paymentId, id, null);
    }

    /**
     * 查询 refund
     *
     * @param paymentId
     * @param id
     * @param options the specific options
     * @return Refund
     * @throws XPayException
     */
    public static Refund retrieve(String paymentId, String id, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/refunds/%s", instanceURL(Payment.class, paymentId), id),null, Refund.class, options);
    }

    /**
     * 查询 refund 列表
     *
     * @param paymentId
     * @param params
     * @return PaymentRefundCollection
     * @throws XPayException
     */
    public static PaymentRefundCollection list(String paymentId, Map<String, Object>params)
            throws XPayException {
        return list(paymentId, params, null);
    }

    /**
     * 查询 refund 列表
     *
     * @param paymentId
     * @param params
     * @param options the specific options
     * @return PaymentRefundCollection
     * @throws XPayException
     */
    public static PaymentRefundCollection list(String paymentId, Map<String, Object>params, RequestOptions options)
            throws XPayException {
        return request(RequestMethod.GET, String.format("%s/refunds", instanceURL(Payment.class, paymentId)),
                params, PaymentRefundCollection.class, options);
    }
}
