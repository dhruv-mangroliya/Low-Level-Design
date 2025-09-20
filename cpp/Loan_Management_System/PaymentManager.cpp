#include "PaymentManager.hpp"
#include "Payment.hpp"
#include "Loan.hpp"
#include <bits/stdc++.h>
#include <vector>
#include <unordered_map>
#include <mutex>

using namespace std;

PaymentManager* PaymentManager::paymentManager = nullptr;
mutex PaymentManager::lock;
PaymentManager::PaymentManager() {
}
PaymentManager* PaymentManager::getPaymentManager(){
    if(paymentManager == nullptr){
        lock.lock();
        if(paymentManager == nullptr){
            paymentManager = new PaymentManager();
        }
        lock.unlock();
    }
    return paymentManager;
}

Payment* PaymentManager::makePayment(string paymentId, Loan* loan, int amount){
    int remainingBill = loan->getLoanAmount() - loan->getReceivedAmount();
    if(amount > remainingBill){
        cout<<"Payment received was more than remaining bill. Payment failed."<<endl;
        return nullptr;
    }
    Payment* newPayment = new Payment(paymentId, amount);
    loan->modifyReceivedAmount(amount);
    loan->addPayment(paymentId);

    paymentData[paymentId] = newPayment;
    paymentBook[loan->getLoanId()].push_back(paymentId);
    cout<<"Payment received for loanId: "<<loan->getLoanId()<<" of amount $"<<amount<<"."<<endl;
    return newPayment;
}

void PaymentManager::showPaymentHistory(string loanId){
    if(paymentBook.find(loanId) == paymentBook.end()){
        cout<<"No payments are received for this loan."<<endl;
        return;
    }
    
    for(string paymentId : paymentBook[loanId]){
        (paymentData[paymentId])->showDetails();
    }
    return;
}