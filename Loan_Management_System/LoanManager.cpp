#include "LoanManager.hpp"
#include <bits/stdc++.h>
#include <vector>
#include <unordered_map>
#include "User.hpp"
#include<mutex>
using namespace std;

mutex LoanManager::lock;
LoanManager* LoanManager::loanManagerInstance = nullptr;

LoanManager::LoanManager(){}

LoanManager* LoanManager::getLoanManagerInstance(){
    if(loanManagerInstance == nullptr){
        lock.lock();
        if(loanManagerInstance==nullptr){
            loanManagerInstance = new LoanManager();
        }
        lock.unlock();
    }
    return loanManagerInstance;
}

Loan* LoanManager::takeLoan (User* user, string loanId, int amount){
    string userId = user->getUserId();
    Loan* newLoan = new Loan(loanId, amount);
    loanData[loanId] = newLoan;
    if(loanBook.find(userId) == loanBook.end()){
        loanBook[userId] = {loanId};
    }else{
        loanBook[userId].push_back(loanId);
        cout<<"Loan added."<<endl;
    }
    this->addLoan(user, amount);
    return newLoan;
}

Payment* LoanManager::payBill(User* user, string paymentId, string loanId, int amount){
    PaymentManager* paymentManager = paymentManager->getPaymentManager();
    Loan* correspondingLoan = loanData[loanId];
    //case: loan may not in user list, he is paying for someone else.
    Payment* payment = paymentManager->makePayment(paymentId, correspondingLoan, amount);
    if(payment != nullptr)
        user->setTotalOutStandingBalance(-amount);
    return payment;
}

void LoanManager::showLoanDetails(string userId){
    if(loanBook.find(userId) == loanBook.end()){
        cout<<"User has not taken any loans."<<endl;
        return;
    }
    int count = 1;
    PaymentManager* paymentManager = paymentManager->getPaymentManager();
    cout<<"_________________________________________________________________________"<<endl;
    cout<<"Loan Detailes for useId: "<<userId<<endl;
    cout<<"_________________________________________________________________________"<<endl;
    for(string loanId : loanBook[userId]){
        cout<<"_________________________________________________________________________"<<endl;
        cout<<"Loan no. : "<<count<<endl;
        
        count++;
        cout<<"     Loan amount: "<<loanData[loanId]->getLoanAmount()<<endl;
        cout<<"     Payment received: "<<loanData[loanId]->getReceivedAmount()<<endl;
        paymentManager->showPaymentHistory(loanId);
        cout<<"_________________________________________________________________________"<<endl;
        cout<<endl;
    }
    cout<<endl;
    cout<<endl;
    return;
}

void LoanManager::addLoan(User* u, int amount){
    u->setTotalOutStandingBalance(amount);
}