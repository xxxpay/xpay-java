package com.xpay.model;

import com.xpay.net.APIResource;


/**
 * Created by sunkai on 15/5/11.
 */
public class Webhooks {
    /**
     * 解析 event 中的 object
     *
     * @param eventStr
     * @return XPayObject
     */
    public static XPayObject getObject(String eventStr) {
        return eventParse(eventStr).getData().getObject();
    }

    /**
     * 解析event，返回Event对象
     *
     * @param eventStr
     * @return Event
     */
    public static Event eventParse(String eventStr) {
        return APIResource.getGson().fromJson(eventStr, Event.class);
    }
}
