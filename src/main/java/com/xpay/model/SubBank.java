package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.Map;

public class SubBank extends APIResource {
    String object;
    String subBank;
    String subBankCode;
    String prov;
    String city;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    public String getSubBankCode() {
        return subBankCode;
    }

    public void setSubBankCode(String subBankCode) {
        this.subBankCode = subBankCode;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 银行支行列表查询
     *
     * @param params 银行编号和省市信息
     * @return SubBankCollection
     * @throws XPayException
     */
    public static SubBankCollection query(Map<String, Object> params)
            throws XPayException {
        return query(params, null);
    }

    /**
     * 银行支行列表查询
     *
     * @param params 银行编号和省市信息
     * @param options the specific options
     * @return SubBankCollection
     * @throws XPayException
     */
    public static SubBankCollection query(Map<String, Object> params, RequestOptions options)
            throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, classURL(SubBank.class), params, SubBankCollection.class, options);
    }
}
