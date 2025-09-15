#ifndef USER_H
#define USER_H

#include <bits/stdc++.h>
#include <vector>

using namespace std;


class User{
    private:
        string userId;
        vector<string> loansTaken;
        int totalOutStandingBalance;
    public:
        User(string id);
        int getTotalOutStandingBalance();
        void setTotalOutStandingBalance(int delta);
        string getUserId();
};


#endif