package com.xpay.net;

import com.xpay.XPay;

public class RequestOptions {
    private final String apiKey;
    private final String appId;
    private final String privateKey;

    private final int connectTimeout;
    private final int readTimeout;

    private final int maxNetworkRetries;

    private final String acceptLanguage;

    public static RequestOptions getDefault() {
        return new RequestOptions(
                XPay.apiKey,
                XPay.appId,
                XPay.privateKey,
                XPay.getConnectTimeout(),
                XPay.getReadTimeout(),
                XPay.getMaxNetworkRetries(),
                XPay.getAcceptLanguage());
    }

    private RequestOptions(
            String apiKey,
            String appId,
            String privateKey,
            int connectTimeout,
            int readTimeout,
            int maxNetworkRetries,
            String acceptLanguage) {
        this.apiKey = apiKey;
        this.appId = appId;
        this.privateKey = privateKey;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.maxNetworkRetries = maxNetworkRetries;
        this.acceptLanguage = acceptLanguage;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAppId() {
        return appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public int getMaxNetworkRetries() {
        return maxNetworkRetries;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public static RequestOptionsBuilder builder() {
        return new RequestOptionsBuilder();
    }

    public static final class RequestOptionsBuilder {
        private String apiKey;
        private String appId;
        private String privateKey;
        private int connectTimeout;
        private int readTimeout;
        private int maxNetworkRetries;
        private String acceptLanguage;

        public RequestOptionsBuilder() {
            this.apiKey = XPay.apiKey;
            this.appId = XPay.appId;
            this.privateKey = XPay.privateKey;
            this.connectTimeout = XPay.getConnectTimeout();
            this.readTimeout = XPay.getReadTimeout();
            this.maxNetworkRetries = XPay.getMaxNetworkRetries();
            this.acceptLanguage = XPay.getAcceptLanguage();
        }

        public String getApiKey() {
            return apiKey;
        }

        public RequestOptionsBuilder setApiKey(String apiKey) {
            this.apiKey = normalizeApiKey(apiKey);
            return this;
        }

        public RequestOptionsBuilder clearApiKey() {
            this.apiKey = null;
            return this;
        }

        public String getAppId() {
            return appId;
        }

        public RequestOptionsBuilder setAppId(String appId) {
            this.appId = normalizeAppId(appId);
            return this;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public RequestOptionsBuilder setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public RequestOptionsBuilder clearAppId() {
            this.appId = null;
            return this;
        }

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public RequestOptionsBuilder setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public int getReadTimeout() {
            return readTimeout;
        }

        public RequestOptionsBuilder setReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public int getMaxNetworkRetries() {
            return maxNetworkRetries;
        }

        public RequestOptionsBuilder setMaxNetworkRetries(int maxNetworkRetries) {
            this.maxNetworkRetries = maxNetworkRetries;
            return this;
        }

        public String getAcceptLanguage() {
            return acceptLanguage;
        }

        public RequestOptionsBuilder setAcceptLanguage(String acceptLanguage) {
            this.acceptLanguage = normalizeAcceptLanguage(acceptLanguage);
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(
                    normalizeApiKey(this.apiKey),
                    normalizeAppId(this.appId),
                    normalizePrivateKey(this.privateKey),
                    connectTimeout,
                    readTimeout,
                    maxNetworkRetries,
                    acceptLanguage);
        }
    }

    private static String normalizeApiKey(String apiKey) {
        // null apiKeys are considered "valid"
        if (apiKey == null) {
            return null;
        }
        String normalized = apiKey.trim();
        if (normalized.isEmpty()) {
            throw new InvalidRequestOptionsException("Empty API key specified!");
        }
        return normalized;
    }

    private static String normalizeAppId(String appId) {
        // null app_ids are considered "valid"
        if (appId == null) {
            return null;
        }
        String normalized = appId.trim();
        if (normalized.isEmpty()) {
            throw new InvalidRequestOptionsException("Empty app_id specified!");
        }
        return normalized;
    }

    private static String normalizePrivateKey(String privateKey) {
        // null privateKey are considered "valid"
        if (privateKey == null) {
            return null;
        }
        String normalized = privateKey.trim();
        if (normalized.isEmpty()) {
            throw new InvalidRequestOptionsException("Empty privateKey specified!");
        }
        return normalized;
    }

    private static String normalizeAcceptLanguage(String acceptLanguage) {
        // null acceptLanguage are considered "valid"
        if (acceptLanguage == null) {
            return null;
        }
        String normalized = acceptLanguage.trim();
        if (normalized.isEmpty()) {
            throw new InvalidRequestOptionsException("Empty Accept-Language specified!");
        }
        return normalized;
    }

    public static class InvalidRequestOptionsException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidRequestOptionsException(String message) {
            super(message);
        }
    }
}
