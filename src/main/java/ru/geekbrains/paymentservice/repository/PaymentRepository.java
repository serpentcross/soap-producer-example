package ru.geekbrains.paymentservice.repository;


import org.springframework.stereotype.Component;
import ru.geekbrains.soap.payment.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentRepository {

    private List<Payment> payments = new ArrayList<>();

    PaymentRepository() {

        Payment payment1 = new Payment();
        payment1.setId(1);
        payment1.setName("PayPal");
        payment1.setCountry("USA");

        Payment payment2 = new Payment();
        payment2.setId(2);
        payment2.setName("GooglePay");
        payment2.setCountry("USA");

        Payment payment3 = new Payment();
        payment3.setId(3);
        payment3.setName("WebMoney");
        payment3.setCountry("Russia");

        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);

    }

    public List<Payment> getPayments(String country) {
        return payments.stream().filter(
            payment -> payment.getCountry().contains(country)
        ).collect(Collectors.toList());
    }

}