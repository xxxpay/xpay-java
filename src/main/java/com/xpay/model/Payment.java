package com.xpay.model;

import com.xpay.exception.InvalidRequestException;
import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.HashMap;
import java.util.Map;

public class Payment extends APIResource {
    String id;
    String object;
    Long created;
    Boolean livemode;
    Boolean paid;
    Boolean refunded;
    Boolean reversed;
    Object app;
    String channel;
    String orderNo;
    String clientIp;
    Integer amount;
    Integer amountSettle;
    String currency;
    String subject;
    String body;
    Long timePaid;
    Long timeExpire;
    Long timeSettle;
    String transactionNo;
    PaymentRefundCollection refunds;
    Integer amountRefunded;
    String failureCode;
    String failureMsg;
    Map<String, Object> metadata;
    Map<String, Object> credential;
    Map<String, Object> extra;
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
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

    public Integer getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Integer amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Integer getAmountSettle() {
        return amountSettle;
    }

    public void setAmountSettle(Integer amountSettle) {
        this.amountSettle = amountSettle;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public PaymentRefundCollection getRefunds() {
        return refunds;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Object getApp() {
        return app;
    }

    public void setApp(Object app) {
        this.app = app;
    }

    public void setCredential(Map<String, Object> credential) {
        this.credential = credential;
    }

    public Map<String, Object> getCredential() {
        return credential;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getTimePaid() {
        return timePaid;
    }

    public void setTimePaid(Long timePaid) {
        this.timePaid = timePaid;
    }

    public Long getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Long timeExpire) {
        this.timeExpire = timeExpire;
    }

    public Long getTimeSettle() {
        return timeSettle;
    }

    public void setTimeSettle(Long timeSettle) {
        this.timeSettle = timeSettle;
    }


    /**
     * 创建 payment
     *
     * @param params
     * @return Payment
     * @throws XPayException
     */
    public static Payment create(Map<String, Object> params)
            throws XPayException {
        return create(params, null);
    }

    /**
     * 创建 payment
     *
     * @param params
     * @param options the specific options
     * @return Payment
     * @throws XPayException
     */
    public static Payment create(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(Payment.class), params, Payment.class, options);
    }

    /**
     * 查询 payment
     *
     * @param id
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrieve(String id) throws XPayException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 payment
     *
     * @param id
     * @param params
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrieve(String id, Map<String, Object> params) throws XPayException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 payment
     *
     * @param id
     * @param options the specific options
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrieve(String id, RequestOptions options) throws XPayException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 payment
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrieve(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Payment.class, id), params, Payment.class, options);
    }

    /**
     * 查询 payment 列表
     *
     * @param params
     * @return PaymentCollection
     * @throws XPayException
     */
    public static PaymentCollection list(Map<String, Object> params)
            throws XPayException {
        return list(params, null);
    }

    /**
     * 查询 payment 列表
     *
     * @param params
     * @param options the specific options
     * @return PaymentCollection
     * @throws XPayException
     */
    public static PaymentCollection list(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        if (params != null
                && ((params.containsKey("app") && (params.get("app") instanceof Map) && ((Map) params.get("app")).containsKey("id"))
                || (params.containsKey("app[id]") && (params.get("app[id]") instanceof String)))) {
            return request(RequestMethod.GET, classURL(Payment.class), params, PaymentCollection.class, options);
        }
        throw new InvalidRequestException(
                "Please pass app[id] as parameter.",
                "invalid_request_error",
                "request_param_error",
                "app[id]",
                0,
                null);
    }

    /**
     * 撤销 payment
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Payment
     * @throws XPayException
     */
    public static Payment reverse(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        String reverseUrl = String.format("%s/reverse", instanceURL(Payment.class, id));
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        return APIResource.request(APIResource.RequestMethod.POST, reverseUrl, params, Payment.class, options);
    }

    /**
     * 撤销 payment
     *
     * @param id
     * @param params
     * @return Payment
     * @throws XPayException
     */
    public static Payment reverse(String id, Map<String, Object> params) throws XPayException {
        return reverse(id, params, null);
    }

    /**
     * 撤销 payment
     *
     * @param id
     * @return Payment
     * @throws XPayException
     */
    public static Payment reverse(String id) throws XPayException {
        return reverse(id, null, null);
    }

    /**
     * 撤销 payment
     *
     * @param id
     * @param options the specific options
     * @return Payment
     * @throws XPayException
     */
    public static Payment reverse(String id, RequestOptions options) throws XPayException {
        return reverse(id, null, options);
    }
}
