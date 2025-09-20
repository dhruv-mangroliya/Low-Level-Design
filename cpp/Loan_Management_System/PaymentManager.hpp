#ifndef PAYMENTMANAGER_H
#define PAYMENTMANAGER_H

#include <bits/stdc++.h>
#include <mutex>
#include<string>
#include "Payment.hpp"
#include "PaymentManager.hpp"
#include "Loan.hpp"

using namespace std;

class PaymentManager{
    private:
        unordered_map<string, Payment*> paymentData;
        unordered_map<string, vector<string>> paymentBook;

        static PaymentManager* paymentManager;
        static mutex lock;

        PaymentManager();
        PaymentManager(PaymentManager& );
        PaymentManager operator=(PaymentManager& );

    public:
        PaymentManager* getPaymentManager();
        Payment* makePayment(string paymentId, Loan* loan, int amount);
        void showPaymentHistory(string loanId);
};




#endif