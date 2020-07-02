package com.xpay.model;

import com.xpay.net.XPayResponse;

public interface XPayObjectInterface {
    public XPayResponse getLastResponse();

    public void setLastResponse(XPayResponse response);
}
