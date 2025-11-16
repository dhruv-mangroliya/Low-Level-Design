package org.example.Template;

public interface RateLimiter {
    public boolean isAllowed(String id);
}
