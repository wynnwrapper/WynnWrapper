package com.wynnwrapper.exceptions;

public class WynnRateLimitException extends WynnWrapperException {
    private long tryAgainAt;
    private boolean internal;

    public WynnRateLimitException(String message, long tryAgainAt, boolean internal) {
        super(message);
        this.tryAgainAt = tryAgainAt;
        this.internal = internal;
    }

    public long tryAgainAt() {
        return tryAgainAt;
    }

    public boolean internal() {
        return internal;
    }
}
