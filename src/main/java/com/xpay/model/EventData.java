package com.xpay.model;

/**
 * Created by Afon on 15/12/30.
 */
public class EventData extends XPayObject {
    XPayObject object;

    public XPayObject getObject() {
        return object;
    }

    public void setObject(XPayObject object) {
        this.object = object;
    }
}
