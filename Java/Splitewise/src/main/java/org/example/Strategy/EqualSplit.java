package org.example.Strategy;

import org.example.Entities.BalanceSheet;
import org.example.Entities.Expense;
import org.example.Entities.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitStrategy{
    private static final Logger logger = LoggerFactory.getLogger(EqualSplit.class);

    public EqualSplit(){
        logger.info("Equal split strategy created.");
    }
    @Override
    public BalanceSheet splitExpense(Expense expense, BalanceSheet balanceSheet){
        List<User> splitAmong = expense.getUsersInvolved();
        double amount = expense.getAmount();
        User paidBy = expense.getPaidBy();

        double membersInvolved = splitAmong.size();
        double individualShare = amount/membersInvolved;

        Map<User, Map<User, Double>> balanceData = balanceSheet.getAmountData();
        Map<User, Double> paidBuUserData = balanceSheet.getAmountData().get(paidBy);
        for(User user: splitAmong){
            if(user.getUserID().equals(paidBy.getUserID())) continue;

            Map<User, Double> usersStatus = balanceData.get(user);
            usersStatus.put(paidBy, usersStatus.get(paidBy) - individualShare);
            paidBuUserData.put(user, paidBuUserData.get(user) + individualShare);
        }

        return balanceSheet;
    }
}
