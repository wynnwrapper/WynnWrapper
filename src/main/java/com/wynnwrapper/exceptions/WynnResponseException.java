package com.wynnwrapper.exceptions;

public class WynnResponseException extends WynnWrapperException {

    private int statusCode;

    public WynnResponseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
