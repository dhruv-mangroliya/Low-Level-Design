package org.example;

import org.example.Entities.Expense;
import org.example.Entities.Group;
import org.example.Entities.Settlement;
import org.example.Entities.User;
import org.example.Factory.GroupFactory;
import org.example.Factory.SpliteStrategyFactory;
import org.example.Factory.UserFactory;
import org.example.Service.SplitewiseService;
import org.example.Strategy.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1  = UserFactory.createUser("U1");
        User user2  = UserFactory.createUser("U2");
        User user3  = UserFactory.createUser("U3");
        User user4  = UserFactory.createUser("U4");
        List<User> manaliMemebers = new ArrayList<>();
        manaliMemebers.add(user1);
        manaliMemebers.add(user2);
        manaliMemebers.add(user3);
        manaliMemebers.add(user4);

        Group manali = GroupFactory.createGroup(manaliMemebers);
        SplitStrategy splitStrategy = SpliteStrategyFactory.createStrategyForSplit("Equal");
        Expense expense = new Expense(user1, 100, manaliMemebers, splitStrategy);

        SplitewiseService splitewiseService = SplitewiseService.getInstance();
        splitewiseService.addExpense(manali, expense);
        splitewiseService.showFinancials(manali);
        Settlement settlement = splitewiseService.generateFinalSettlement(manali);

        for(User user: settlement.getSettlementTranscations().keySet()){
            for(User borrower: settlement.getSettlementTranscations().get(user).keySet()){
                System.out.println(user.getUserID() + " owes " + borrower.getUserID() + " an amount of " + settlement.getSettlementTranscations().get(user).get(borrower));
            }
        }
    }
}