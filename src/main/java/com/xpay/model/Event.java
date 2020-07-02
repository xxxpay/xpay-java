package com.xpay.model;

import com.xpay.exception.XPayException;
import com.xpay.net.APIResource;
import com.xpay.net.RequestOptions;

import java.util.Map;

/**
 * Created by sunkai on 15/5/11.
 */
public class Event extends APIResource {
    private String id;
    private String object;
    private Boolean livemode;
    private Long created;
    private EventData data;
    private Integer pendingWebhooks;
    private String type;
    private String request;

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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public EventData getData() {
        return data;
    }

    public void setData(EventData data) {
        this.data = data;
    }

    public Integer getPendingWebhooks() {
        return pendingWebhooks;
    }

    public void setPendingWebhooks(Integer pendingWebhooks) {
        this.pendingWebhooks = pendingWebhooks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    /**
     * 查询 Event
     *
     * @param id
     * @return Event
     * @throws XPayException
     */
    public static Event retrieve(String id) throws XPayException {
        return retrieve(id, null, null);
    }

    /**
     * 查询 Event
     *
     * @param id
     * @param options  XPay ApiKey
     * @return Event
     * @throws XPayException
     */
    public static Event retrieve(String id, RequestOptions options) throws XPayException {
        return retrieve(id, null, options);
    }

    /**
     * 查询 Event
     *
     * @param id
     * @param params
     * @return Event
     * @throws XPayException
     */
    public static Event retrieve(String id, Map<String, Object> params) throws XPayException {
        return retrieve(id, params, null);
    }

    /**
     * 查询 Event
     *
     * @param id
     * @param params
     * @param options the specific options
     * @return Event
     * @throws XPayException
     */
    public static Event retrieve(String id, Map<String, Object> params, RequestOptions options) throws XPayException {
        return APIResource.request(APIResource.RequestMethod.GET, instanceURL(Event.class, id), params, Event.class, options);
    }
}
