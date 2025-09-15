#ifndef LOANMANAGER_H
#define LOANMANAGER_H

#include <bits/stdc++.h>
#include <vector>
#include <unordered_map>
#include<string>
#include "Loan.hpp"
#include "Payment.hpp"
#include "PaymentManager.hpp"
#include "User.hpp"
#include <mutex>

using namespace std;

class LoanManager{
    private:
        unordered_map<string, Loan*> loanData;
        unordered_map<string, vector<string>> loanBook;
        static mutex lock;
        static LoanManager* loanManagerInstance;
        LoanManager();
        LoanManager(LoanManager&);
        LoanManager operator=(LoanManager&);
    public:
        Loan* takeLoan (User* userId, string loanId, int amount);
        Payment* payBill(User* user, string paymentId, string loanId, int amount);
        void showLoanDetails(string userId);
        void addLoan(User* u, int amount);
        static LoanManager* getLoanManagerInstance();
};

#endif