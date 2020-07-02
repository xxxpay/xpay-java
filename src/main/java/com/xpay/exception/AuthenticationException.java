package com.xpay.exception;

public class AuthenticationException extends XPayException {


    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, String type, String code, int statusCode, Throwable e) {
        super(message, type, code, statusCode, e);
    }

    private static final long serialVersionUID = 2L;

}
