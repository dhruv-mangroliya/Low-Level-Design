package org.example.Models;

import org.example.Template.TemplateRateLimiter;

public class RateLimitingManager {
    private TemplateRateLimiter templateRateLimiter;
    private static volatile RateLimitingManager instance;

    private RateLimitingManager(){
    }

    public static synchronized RateLimitingManager getInstance(){
        if(instance == null){
            instance = new RateLimitingManager();
            return instance;
        }
        return instance;
    }

    public void setTemplateRateLimiter(TemplateRateLimiter templateRateLimiter){
        this.templateRateLimiter = templateRateLimiter;
        return;
    }

    public boolean hitAPI(String id){
        return templateRateLimiter.isAllowed(id);
    }
}
