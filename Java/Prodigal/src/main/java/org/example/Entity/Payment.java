package org.example.Entity;

import lombok.Getter;
import lombok.Setter;
import org.example.Enums.PaymentMethod;


@Setter @Getter
public class Payment {
    private int paymentId;
    private Loan loan;
    private int paymentAmount;
    private PaymentMethod paymentMethod;

    public Payment(int paymentId, Loan loan, int paymentAmount, PaymentMethod paymentMethod){
        this.loan = loan;
        this.paymentId = paymentId;
        this.paymentMethod  = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public void showDetails(){
        System.out.println("ID: " + this.getPaymentId());
        System.out.println("Amount: " + this.getPaymentAmount());
        System.out.println("Loan ID: " + this.getLoan().getLoanId());
        System.out.println("Method: " + this.getPaymentMethod().toString());
        return;
    }
}
