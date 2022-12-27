package ua.edu.ucu.flowerstore.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = PayPalPaymentStrategy.class)
public class PayPalPaymentStrategy implements Payment {
    @JsonProperty(value = "paymentType")
    String paymentType;
    @Override
    public void pay(double price) {
        System.out.println("Payment method : PayPal");
        // ask for e-mail
        System.out.println("Grand total : " + price);
    }

    @Override
    public String toString() {
        return "PayPalPaymentStrategy{}";
    }
}
