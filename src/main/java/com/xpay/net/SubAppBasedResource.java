package com.xpay.net;

import com.xpay.XPay;

public abstract class SubAppBasedResource extends AppBasedResource {

    /**
     * @param clazz the class of object
     * @param subAppId the ID of sub_app
     * @return singleClassURL
     */
    protected static String singleClassURL(Class<?> clazz, String subAppId) {
        return String.format("%s/v2/apps/%s/sub_apps/%s/%s", XPay.getApiBase(), APIResource.URIAppIdHolder, subAppId, className(clazz));
    }

    /**
     * @param clazz the class of object
     * @param subAppId the ID of sub_app
     * @return classURL
     */
    protected static String classURL(Class<?> clazz, String subAppId) {
        return String.format("%ss", singleClassURL(clazz, subAppId));
    }

    /**
     * @param clazz the class of object
     * @param subAppId the ID of sub_app
     * @param id the id of object
     * @return instanceURL
     */
    protected static String instanceURL(Class<?> clazz, String subAppId, String id) {
        return String.format("%s/%s", classURL(clazz, subAppId), urlEncode(id));
    }
}
