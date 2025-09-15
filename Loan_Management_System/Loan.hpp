#ifndef LOAN_H
#define LOAN_H

#include <bits/stdc++.h>
#include <vector>
#include<string>
#include <unordered_map>
using namespace std;

class Loan{
    private:
        string loanId;
        vector<string> paymentIds;
        int loanAmount;
        int receivedAmount;
    public:

    Loan(string loadId, int amount);

    string getLoanId();

    int getLoanAmount();

    int getReceivedAmount();

    void modifyReceivedAmount(int delta);

    void addPayment(string paymentId);
};




#endif