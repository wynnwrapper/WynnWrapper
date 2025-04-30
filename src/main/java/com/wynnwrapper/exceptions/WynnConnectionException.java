package com.wynnwrapper.exceptions;

public class WynnConnectionException extends WynnWrapperException {
    public WynnConnectionException(String message) {
        super(message);
    }

    public WynnConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public WynnConnectionException(Throwable cause) {
        super(cause);
    }
}
