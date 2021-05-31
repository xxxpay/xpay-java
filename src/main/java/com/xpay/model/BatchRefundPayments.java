package com.xpay.model;

/**
 * Created by Afon on 17/01/12.
 */
public class BatchRefundPayments extends XPayObject {
    String payment;
    Integer amount;
    String description;
    String status;
    String fundingSource;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String account) {
        this.payment = payment;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }
}
