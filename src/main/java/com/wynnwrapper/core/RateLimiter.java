package com.wynnwrapper.core;

public class RateLimiter {

    private long rateLimitResetTimestamp = 0;
    private int rateLimitRemaining = 0;
    private int rateLimitMax = 0;

    public synchronized void updateRateLimit(long resetTime, int remaining, int max) {
        if (remaining < rateLimitRemaining || resetTime > rateLimitResetTimestamp) {
            this.rateLimitResetTimestamp = resetTime;
            this.rateLimitRemaining = remaining;
            this.rateLimitMax = max;
        }
    }

    public boolean isRateLimited() {
        return ((rateLimitRemaining <= 0) && (rateLimitResetTimestamp > System.currentTimeMillis()));
    }

    public synchronized void decrementRateLimit() {
        this.rateLimitRemaining -= 1;
    }

    public long rateLimitResetTimestamp() {
        return rateLimitResetTimestamp;
    }

    public int rateLimitRemaining() {
        return rateLimitRemaining;
    }

    public int rateLimitMax() {
        return rateLimitMax;
    }
}
