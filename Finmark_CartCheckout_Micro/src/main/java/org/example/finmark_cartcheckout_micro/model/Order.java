package org.example.finmark_cartcheckout_micro.model;

public class Order {

    private String payerName;
    private String refNumber;
    private String orderSummary;
    private double totalAmount;

    //constructors

    public Order() {}

    public Order(String payerName, String refNumber, String orderSummary, double totalAmount) {
        this.payerName = payerName;
        this.refNumber = refNumber;
        this.orderSummary = orderSummary;
        this.totalAmount = totalAmount;
    }

    //getters and setters
    public String getPayerName() { return payerName; }
    public void setPayerName(String payerName) { this.payerName = payerName; }

    public String getRefNumber() { return refNumber; }
    public void setRefNumber(String refNumber) { this.refNumber = refNumber; }

    public String getOrderSummary() { return orderSummary; }
    public void setOrderSummary(String orderSummary) { this.orderSummary = orderSummary; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
