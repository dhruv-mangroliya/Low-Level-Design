#include <bits/stdc++.h>
#include "User.hpp"
#include "Loan.hpp"
#include "LoanManager.hpp"
#include "Payment.hpp"
#include "PaymentManager.hpp"

using namespace std;


int main(){
    User* user1 = new User("User001");
    User* user2 = new User("User002");

    LoanManager* lm = LoanManager::getLoanManagerInstance();
    lm->takeLoan(user1, "Loan11", 1000);
    lm->takeLoan(user2, "Loan21", 100);

    lm->payBill(user1, "Payment1", "Loan11", 500);
    
    lm->takeLoan(user1, "Loan12", 2000);
    lm->takeLoan(user1, "Loan13", 3000);

    lm->payBill(user1, "Payment2", "Loan11", 500); 
    lm->payBill(user1, "Payment3", "Loan11", 500); //should throw error
    lm->payBill(user2, "Payment4", "Loan21", 100);

    lm->showLoanDetails("User001");
    lm->showLoanDetails("User002");

    user1->getTotalOutStandingBalance();
    user2->getTotalOutStandingBalance();
    
    return 0;
}