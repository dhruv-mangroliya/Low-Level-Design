#include "User.hpp"

User::User(string id){
    this->userId = id;
    this->totalOutStandingBalance = 0;
}

int User::getTotalOutStandingBalance(){
cout<<"Outstanding Balance for user: "<<this->userId<<" is "<< this->totalOutStandingBalance<<endl;
    return this->totalOutStandingBalance;
}
string User::getUserId(){
    return this->userId;
}
void User::setTotalOutStandingBalance(int delta){
    this->totalOutStandingBalance += delta;
    return;
}
