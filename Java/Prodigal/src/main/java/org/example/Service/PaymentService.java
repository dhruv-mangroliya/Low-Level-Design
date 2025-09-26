package org.example.Service;

import org.example.Entity.Loan;
import org.example.Entity.Payment;
import org.example.Enums.PaymentMethod;

import java.util.ArrayList;
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
        if(loanData.get(loanId) == null){
            System.out.println("No loan");
            return;
        }

        List<Integer> list = loanToPayment.get(loanId);
        if(list == null) list = new ArrayList<>();
        if(list.contains(paymentId)){
            System.out.println("Payment ID invalid...");
            return;
        }

        Loan correspondingLoan = loanData.get(loanId);
        Boolean res = correspondingLoan.updateOutstandingAmount(amount);
        if(res == false){
            return;
        }
        Payment payment = new Payment(paymentId, correspondingLoan, amount, method);
        paymentData.put(paymentId, payment);

        list.add(paymentId);
        loanToPayment.put(loanId, list);

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
        System.out.println(list);
        if(list == null) {
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
        if(paymentData.get(paymentId)==null){
            System.out.println("Issue with PaymentID");
            return;
        }
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
