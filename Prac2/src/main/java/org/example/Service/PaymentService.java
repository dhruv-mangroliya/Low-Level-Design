package org.example.Service;

import org.example.Entity.Loan;
import org.example.Entity.Payment;
import org.example.Enums.PaymentMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentService implements PayService{
    private static volatile PaymentService instance;
    Map<Integer, Loan> loanData = new HashMap<Integer, Loan>();
    Map<Integer, Payment> paymentData = new HashMap<Integer, Payment>();
    Map<Integer, List<Integer>> loanToPayment = new HashMap<Integer, List<Integer>>();

    public static synchronized PaymentService getInstance(){
        if(instance == null){
            instance = new PaymentService();
        }
        return instance;
    }

    @Override
    public void addPayment(int loanId, int paymentId, int amount, PaymentMethod method) {
        if(loanData.get((Integer) loanId) == null){
            System.out.println("No loan");
            return;
        }
        Loan correspondingLoan = loanData.get(loanId);
        Boolean res = correspondingLoan.updateOutstandingAmount(amount);
        if(res == false){
            return;
        }
        Payment payment = new Payment(paymentId, correspondingLoan, amount, method);
        paymentData.put(paymentId, payment);
        List<Integer> list = loanToPayment.get(loanId);
        list.add(paymentId);

        return;
    }

    public void takeLoan(int loanId, int amount){
        Loan loan = new Loan(loanId, amount);
        loanData.put(loanId, loan);
        System.out.println(loan.getLoanId() + " " + loan.getOutstandingAmount());
        return;
    }

    @Override
    public void getPaymentsForLoan(int loanId) {
        List<Integer> list = loanToPayment.get(loanId);
        if(list.size() == 0) {
            System.out.println("No payments found!!!");
            return;
        }
        for(Integer paymentiD : list){
            Payment p = paymentData.get(paymentiD);
            p.showDetails();
        }
        return;
    }

    @Override
    public void updatePaymentMethod(int paymentId, PaymentMethod method) {
        Payment payment = paymentData.get(paymentId);
        payment.setPaymentMethod(method);
        return;
    }

    @Override
    public void getOutstandingAmount(int loanId) {
        Loan loan = loanData.get(loanId);
        int amount = loan.getOutstandingAmount();
        System.out.println(amount);
    }
}
