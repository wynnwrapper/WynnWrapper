package com.wynnwrapper.exceptions;

public class WynnWrapperException extends RuntimeException {
    public WynnWrapperException(String message) {
        super(message);
    }

    public WynnWrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public WynnWrapperException(Throwable cause) {
        super(cause);
    }
}
