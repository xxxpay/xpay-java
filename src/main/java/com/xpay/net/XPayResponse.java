package com.xpay.net;

/**
 * Handler XPay response when you request payment from xpay
 */
public class XPayResponse {

    private int responseCode;
    private String responseBody;
    private HttpHeaders responseHeaders;

    private int numRetries;

    /**
     * @param responseCode the HTTP Status Code
     * @param responseBody the response body
     */
    public XPayResponse(int responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = null;
    }

    /**
     * @param responseCode the HTTP Status Code
     * @param responseBody the response body
     * @param responseHeaders the response headers
     */
    public XPayResponse(int responseCode, String responseBody, HttpHeaders responseHeaders) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    /**
     * get http responseCode
     * @return responseCode
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode the HTTP Status Code
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return responseBody
     */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     *
     * @param responseBody the response body
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    /**
     *
     * @return responseHeaders
     */
    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    public int getNumRetries() {
        return numRetries;
    }

    public void setNumRetries(int numRetries) {
        this.numRetries = numRetries;
    }
}
