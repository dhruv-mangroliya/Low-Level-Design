package org.example.Strategy;

import org.example.Template.TemplateRateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FixedWindowRateLimitingStrategy extends TemplateRateLimiter {
    private Map<String, Long> clientMapping;
    private Map<String, Integer> clientCount;

    public FixedWindowRateLimitingStrategy(int maxRequest, Long windowSize){
        super(maxRequest, windowSize);
        clientMapping = new HashMap<>();
        clientCount = new HashMap<>();
    }

    @Override
    protected boolean checkRequest(String id) {
        Long currentTimeInMiliSeconds = System.currentTimeMillis();
        clientMapping.putIfAbsent(id, 0L);
        clientCount.putIfAbsent(id, 0);

        Long windowStartTime = clientMapping.get(id);
        if(currentTimeInMiliSeconds - windowStartTime >= getWindowSize()){
            clientMapping.put(id, currentTimeInMiliSeconds);
            clientCount.put(id, 0);
        }
        int hits = clientCount.get(id);
        if(hits < getMaxRequest()){
            clientCount.put(id, hits+1);
            return true;
        }
        return false;
    }
}
