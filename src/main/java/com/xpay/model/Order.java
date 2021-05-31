package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order extends APIResource {
    String id;
    String object;
    Long created;
    Boolean livemode;
    String status;
    Boolean paid;
    Boolean refunded;
    Object app;
    String payment;
    String uid;
    String merchantOrderNo;
    Integer amount;
    Integer couponAmount;
    Integer actualAmount;
    Integer amountRefunded;
    Integer amountPaid;
    String currency;
    String subject;
    String body;
    String clientIp;
    Long timePaid;
    Long timeExpire;
    String coupon;
    PaymentCollection payments;
    String description;
    Map<String, Object> metadata;
    PaymentEssentials paymentEssentials;
    Long availableBalance;
    String receiptApp;
    String serviceApp;
    List<String> availableMethods;
    Integer discountAmount;

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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Object getApp() {
        return app;
    }

    public void setApp(Object app) {
        this.app = app;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Integer getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(Integer actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Integer getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(Integer amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
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

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public PaymentCollection getPayments() {
        return payments;
    }

    public void setPayments(PaymentCollection payments) {
        this.payments = payments;
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

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public PaymentEssentials getPaymentEssentials() {
        return paymentEssentials;
    }

    public void setPaymentEssentials(PaymentEssentials paymentEssentials) {
        this.paymentEssentials = paymentEssentials;
    }

    public Long getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getReceiptApp() {
        return receiptApp;
    }

    public void setReceiptApp(String receiptApp) {
        this.receiptApp = receiptApp;
    }

    public String getServiceApp() {
        return serviceApp;
    }

    public void setServiceApp(String serviceApp) {
        this.serviceApp = serviceApp;
    }

    public List<String> getAvailableMethods() {
        return availableMethods;
    }

    public void setAvailableMethods(List<String> availableMethods) {
        this.availableMethods = availableMethods;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 创建 order
     *
     * @param params
     * @return Order
     * @throws XPayException
     */
    public static Order create(Map<String, Object> params)
            throws XPayException {
        return create(params, null);
    }

    /**
     * 创建 order
     *
     * @param params
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order create(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, classURL(Order.class), params, Order.class, options);
    }

    /**
     * 查询 order
     *
     * @param id
     * @return Order
     * @throws XPayException
     */
    public static Order retrieve(String id) throws XPayException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 order
     *
     * @param id
     * @param params
     * @return Order
     * @throws XPayException
     */
    public static Order retrieve(String id, Map<String, Object> params) throws XPayException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 order
     *
     * @param id
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order retrieve(String id, RequestOptions options) throws XPayException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 order
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order retrieve(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Order.class, id), params, Order.class, options);
    }

    /**
     * 查询 order 列表
     *
     * @param params
     * @return OrderCollection
     * @throws XPayException
     */
    public static OrderCollection list(Map<String, Object> params)
            throws XPayException {
        return list(params, null);
    }

    /**
     * 查询 order 列表
     *
     * @param params
     * @param options the specific options
     * @return OrderCollection
     * @throws XPayException
     */
    public static OrderCollection list(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(Order.class), params, OrderCollection.class, options);
    }

    /**
     * 更新 order
     *
     * @param id
     * @param params
     * @return Order
     * @throws XPayException
     */
    public static Order update(String id, Map<String, Object> params)
            throws XPayException {
        return update(id, params, null);
    }

    /**
     * 更新 order
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order update(String id, Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.PUT, instanceURL(Order.class, id), params, Order.class, options);
    }

    /**
     * 取消 order
     *
     * @return Order
     * @throws XPayException
     */
    public Order cancel()
            throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return Order.update(this.getId(), params, null);
    }

    /**
     * 取消 order
     *
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public Order cancel(RequestOptions options)
            throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return Order.update(this.getId(), params, options);
    }

    /**
     * 取消 order
     *
     * @param id
     * @return Order
     * @throws XPayException
     */
    public static Order cancel(String id)
            throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return update(id, params);
    }

    /**
     * 取消 order
     *
     * @param id
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order cancel(String id, RequestOptions options)
            throws XPayException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "canceled");
        return update(id, params, options);
    }

    /**
     * 支付 order
     *
     * @param params
     * @return Order
     * @throws XPayException
     */
    public Order pay(Map<String, Object> params) throws XPayException {
        return Order.pay(this.getId(), params, null);
    }

    /**
     * 支付 order
     *
     * @param params
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public Order pay(Map<String, Object> params, RequestOptions options) throws XPayException {
        return Order.pay(this.getId(), params, options);
    }

    /**
     * 支付 order
     *
     * @param id
     * @param params
     * @return Order
     * @throws XPayException
     */
    public static Order pay(String id, Map<String, Object> params) throws XPayException {
        return pay(id, params, null);
    }

    /**
     * 支付 order
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Order
     * @throws XPayException
     */
    public static Order pay(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.POST, String.format("%s/pay",
                instanceURL(Order.class, id)), params, Order.class, options);
    }

    /**
     * 查询订单 Payment 列表
     *
     * @param id
     * @param params
     * @return PaymentCollection
     * @throws XPayException
     */
    public static PaymentCollection paymentList(String id, Map<String, Object> params) throws XPayException {
        return paymentList(id, params, null);
    }

    /**
     * 查询订单 Payment 列表
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return PaymentCollection
     * @throws XPayException
     */
    public static PaymentCollection paymentList(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/payments", instanceURL(Order.class, id)),
                params, PaymentCollection.class, options);
    }

    /**
     * 查询订单 Payment
     *
     * @param orderId
     * @param paymentId
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrievePayment(String orderId, String paymentId) throws XPayException {
        return retrievePayment(orderId, paymentId, null);
    }

    /**
     * 查询订单 Payment
     *
     * @param orderId
     * @param paymentId
<<<<<<< HEAD
     * @param options  the specific options
=======
     * @param options the specific options
>>>>>>> 9c6801405ecca334607545f80e042135336029f8
     * @return Payment
     * @throws XPayException
     */
    public static Payment retrievePayment(String orderId, String paymentId, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, String.format("%s/payments/%s", instanceURL(Order.class, orderId), paymentId),
                null, Payment.class, options);
    }
}
