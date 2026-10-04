package org.example.Template;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Queue;

@Setter
@Getter
public abstract class TemplateRateLimiter implements RateLimiter{
    private Integer maxRequest;
    private Long windowSize;

    public TemplateRateLimiter(int maxRequest, Long windowSize){
        this.maxRequest = maxRequest;
        this.windowSize = windowSize;
    }

    protected TemplateRateLimiter() {
    }

    @Override
    public boolean isAllowed(String id){
        return checkRequest(id);
    }

    protected abstract boolean checkRequest(String id);
}
