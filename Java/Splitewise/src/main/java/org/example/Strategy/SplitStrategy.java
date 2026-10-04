package org.example.Strategy;

import org.example.Entities.BalanceSheet;
import org.example.Entities.Expense;

public interface SplitStrategy {
    public BalanceSheet splitExpense(Expense expense, BalanceSheet balanceSheet);
}
