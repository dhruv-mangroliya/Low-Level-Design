package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Loan {
    private int loanId;
    private int loanAmount;
    private int outstandingAmount;

    public Loan(int loanId, int loanAmount){
        this.loanAmount = loanAmount;
        this.loanId = loanId;
        this.outstandingAmount = loanAmount;
    }

    public Boolean updateOutstandingAmount(int paymentAmount) {
        if(paymentAmount > this.outstandingAmount){
            System.out.println("Payment is more than outstanding amount. Failed...");
            return false;
        }
        setOutstandingAmount(this.getOutstandingAmount() - paymentAmount);
        return true;
    }
}
