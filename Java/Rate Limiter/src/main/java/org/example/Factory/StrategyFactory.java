package org.example.Factory;

import org.example.Exceptions.WrongRateLimiterRequested;
import org.example.Strategy.FixedWindowRateLimitingStrategy;
import org.example.Strategy.SlidingWindowRateLimitingStrategy;
import org.example.Template.TemplateRateLimiter;

public class StrategyFactory {
    public StrategyFactory(){}

    public static TemplateRateLimiter createRateLimitingStrategy(String name, Integer maxRequest, Long windowSize){
        if("Fixed Window".equals(name)){
            return new FixedWindowRateLimitingStrategy(maxRequest, windowSize);
        }else if("Sliding Window".equals(name)){
            return new SlidingWindowRateLimitingStrategy(maxRequest, windowSize);
        }else{
            throw new WrongRateLimiterRequested();
        }
    }
}
