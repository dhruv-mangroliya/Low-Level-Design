package org.example.Service;

import org.example.Enums.PaymentMethod;

public interface PayService {
    void addPayment(int loanId, int paymentId, int amount, PaymentMethod method);
    void getPaymentsForLoan(int loanId);
    void updatePaymentMethod(int paymentId, PaymentMethod method);
    void getOutstandingAmount(int loanId);
}
