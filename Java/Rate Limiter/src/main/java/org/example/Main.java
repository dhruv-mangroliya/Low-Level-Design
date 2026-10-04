package org.example;

import org.example.Factory.StrategyFactory;
import org.example.Models.RateLimitingManager;
import org.example.Template.TemplateRateLimiter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TemplateRateLimiter templateRateLimiter = StrategyFactory.createRateLimitingStrategy("Fixed Window", 2, 1000L);
        RateLimitingManager rateLimitingManager = RateLimitingManager.getInstance();
        rateLimitingManager.setTemplateRateLimiter(templateRateLimiter);

        for(int i=0;i<3;i++){
            Thread.sleep(300);
            System.out.println(rateLimitingManager.hitAPI("Client001"));
        }

        System.out.println("_______________");
        templateRateLimiter = StrategyFactory.createRateLimitingStrategy("Sliding Window", 3, 2000L);
        rateLimitingManager.setTemplateRateLimiter(templateRateLimiter);

        for(int i=0;i<10;i++){
            System.out.println(rateLimitingManager.hitAPI("Client001"));
            Thread.sleep(500);
        }
        System.out.println("_______________");
        templateRateLimiter = StrategyFactory.createRateLimitingStrategy("Sliding_Window", 3, 2000L);
    }
}