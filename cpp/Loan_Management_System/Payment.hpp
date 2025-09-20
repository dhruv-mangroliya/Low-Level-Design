#ifndef PAYMENT_H
#define PAYMENT_H

#include <bits/stdc++.h>
#include <vector>
#include<string>
using namespace std;

class Payment{
    private:
        string paymentId;
        int paymentAmount;

    public:

    Payment(string paymentId, int amount);
    string getPaymentId();
    int getPaymentAmount();
    void showDetails();
};




#endif