#include "Payment.hpp"

Payment::Payment(string paymentId, int amount){
    this->paymentId = paymentId;
    this->paymentAmount = amount;
}
string Payment::getPaymentId(){
    return this->paymentId;
}
int Payment::getPaymentAmount(){
    return this->paymentAmount;
}
void Payment::showDetails(){
    cout<<"Payment Details:-"<<endl;
    cout<<"       ID: "<<this->getPaymentId()<<", Amount Received: "<<this->getPaymentAmount()<<"."<<endl;
    return;
}