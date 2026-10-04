package org.example.Strategy;

import org.example.Template.TemplateRateLimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimitingStrategy extends TemplateRateLimiter {
    private Map<String, Queue<Long>> clientMapping;

    public SlidingWindowRateLimitingStrategy(int maxRequest, Long windowSize){
        super(maxRequest, windowSize);
        clientMapping = new HashMap<>();
    }

    @Override
    protected boolean checkRequest(String id) {
        Long currentTimeInMiliSeconds = System.currentTimeMillis();
        clientMapping.putIfAbsent(id, new LinkedList<>());

        Queue<Long> clientData = clientMapping.get(id);
        Long windowStart = clientData.peek();

        while(!clientData.isEmpty() && currentTimeInMiliSeconds - windowStart > getWindowSize()){
            clientData.poll();
        }
        if(clientData.size() < getMaxRequest()){
            clientData.add(currentTimeInMiliSeconds);
            clientMapping.put(id, clientData);
            return true;
        }

        return  false;
    }
}
