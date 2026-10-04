package org.example.Service;

import org.example.Entities.*;
import org.example.Strategy.SplitStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SplitewiseService {
    private static final Logger logger = LoggerFactory.getLogger(SplitewiseService.class);
    private static volatile SplitewiseService instance = null;

    private SplitewiseService(){

    }

    public static synchronized SplitewiseService getInstance(){
        if(instance == null){
            return instance = new SplitewiseService();
        }
        return instance;
    }

    public void addExpense(Group group, Expense expense){
        SplitStrategy splitStrategy = expense.getSplitStrategy();
        BalanceSheet updatedBalanceSheet = splitStrategy.splitExpense(expense, group.getBalanceSheet());
        group.setBalanceSheet(updatedBalanceSheet);
        return;
    }

    public void showFinancials(Group group){
        BalanceSheet balanceSheet = group.getBalanceSheet();

        for(User member: group.getMembers()){
            Map<User, Double> userData = balanceSheet.getAmountData().get(member);

            for(User user2: userData.keySet()){
                logger.info("{} -> {}, {}", member.getUserID(), user2.getUserID(), userData.get(user2));
            }
        }
    }

    public Settlement generateFinalSettlement(Group group){
        PriorityQueue<Map.Entry<Double, User>> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getKey(), a.getKey())
        );
        PriorityQueue<Map.Entry<Double, User>> minHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getKey(), b.getKey())
        );

        BalanceSheet balanceSheet = group.getBalanceSheet();
        Map<User, Map<User, Double>> amountData = balanceSheet.getAmountData();
        List<User> members = group.getMembers();

        for(User member1: members){
            Double overallSum = 0.0;
            for(User member2 : members) {
                if (member2.getUserID().equals(member1.getUserID())) continue;
                Double amountLeft = amountData.get(member1).get(member2);
                overallSum += amountLeft;
            }
            if(overallSum <= 0.0){
                maxHeap.add(Map.entry(1.0*overallSum, member1));
            }else{
                minHeap.add(Map.entry(1.0*overallSum, member1));
            }
        }

        //min heap is receiver
        //max heap is borower
        Map<User, Map<User, Double>> transactions = new HashMap<>();
        while(!maxHeap.isEmpty() && !minHeap.isEmpty()){
            Map.Entry<Double, User> receiver = minHeap.peek();
            minHeap.poll();

            Map.Entry<Double, User> borowwer = maxHeap.peek();
            maxHeap.poll();

            Double receiveAmount = Math.abs(receiver.getKey());
            Double borrowedAmount = Math.abs(borowwer.getKey());
            User receiverUser = receiver.getValue();
            User borowwerUser = borowwer.getValue();
            transactions.computeIfAbsent(receiverUser, k -> new HashMap<>())
                    .put(borowwerUser, Math.min(receiveAmount , borrowedAmount));
            if(receiveAmount > borrowedAmount){
                logger.info("{} will pay {} {}", borowwerUser.getUserID(), receiverUser.getUserID(), borrowedAmount);
                Double restOfTheDiff = receiveAmount - borrowedAmount;
                logger.debug("Remaining amount for {}: {}", receiverUser.getUserID(), restOfTheDiff);
                minHeap.add(Map.entry(restOfTheDiff, receiverUser));

            }else if(receiveAmount < borrowedAmount){
                logger.info("{} will receive {} from {}", receiverUser.getUserID(), receiveAmount, borowwerUser.getUserID());
                Double restOfTheDiff = -1.0*(borrowedAmount - receiveAmount);
                logger.debug("Remaining amount for {}: {}", borowwerUser.getUserID(), restOfTheDiff);
                maxHeap.add(Map.entry(restOfTheDiff, borowwerUser));
            }else{
                logger.info("{} will receive {} from {}", receiverUser.getUserID(), receiveAmount, borowwerUser.getUserID());
            }
        }
        Settlement settlement = new Settlement(transactions);
        logger.debug("minHeap empty: {}, maxHeap empty: {}", minHeap.isEmpty(), maxHeap.isEmpty());
        return settlement;
    }
}
