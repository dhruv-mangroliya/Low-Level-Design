package org.example;

import org.example.Enums.PaymentMethod;
import org.example.Service.PaymentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentService paymentService = PaymentService.getInstance();

        paymentService.takeLoan(1, 1000);
        paymentService.addPayment(1, 1, 500, PaymentMethod.CREDIT_CARD);
        System.out.println();
        paymentService.getPaymentsForLoan(1);
        System.out.println();
        paymentService.getOutstandingAmount(1);
        System.out.println();

        paymentService.addPayment(1, 1, 500, PaymentMethod.CREDIT_CARD);
        System.out.println();
        paymentService.getPaymentsForLoan(1);
        System.out.println();
        paymentService.getOutstandingAmount(1);
        System.out.println();

        paymentService.updatePaymentMethod(1, PaymentMethod.BANK_TRANSFER);
        System.out.println();
        paymentService.getPaymentsForLoan(1);
        System.out.println();

    }
}