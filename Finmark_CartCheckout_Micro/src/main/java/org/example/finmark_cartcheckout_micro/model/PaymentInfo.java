package org.example.finmark_cartcheckout_micro.model;

public class PaymentInfo {

    private String cardHolderName;
    private String cardNumber;
    private double amount;

    public PaymentInfo(String cardHolderName, String cardNumber, double amount) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardHolderName() { return cardHolderName; }
    public String getCardNumber() { return cardNumber; }
    public double getAmount() { return amount; }

}
