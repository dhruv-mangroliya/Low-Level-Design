package org.example.Entities;

import lombok.Getter;
import lombok.Setter;
import org.example.Strategy.SplitStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Getter
@Setter
public class Expense {
    private static final Logger logger = LoggerFactory.getLogger(Expense.class);
    private User paidBy;
    private double amount;
    private List<User> usersInvolved;
    private SplitStrategy splitStrategy;

    public Expense(User paidBy, double amount, List<User> usersInvolved, SplitStrategy splitStrategy){
        this.amount = amount;
        this.paidBy = paidBy;
        this.usersInvolved = usersInvolved;
        this.splitStrategy = splitStrategy;
        logger.info("{} paid the expense of amount {}.", paidBy.getUserID(), amount);
    }

}
