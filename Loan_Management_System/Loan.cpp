#include "Loan.hpp"

Loan::Loan(string loanId, int amount){
    this->loanId = loanId;
    this->loanAmount = amount;
}

string Loan::getLoanId(){
    return this->loanId;
}

int Loan::getLoanAmount(){
    return this->loanAmount;
}

int Loan::getReceivedAmount(){
    return this->receivedAmount;
}

void Loan::modifyReceivedAmount(int delta){
    this->receivedAmount += delta;
}

void Loan::addPayment(string id){
    (this->paymentIds).push_back(id);
}