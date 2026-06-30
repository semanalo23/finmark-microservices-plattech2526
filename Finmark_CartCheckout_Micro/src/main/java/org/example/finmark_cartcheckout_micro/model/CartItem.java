package org.example.finmark_cartcheckout_micro.model;

public class CartItem {

    private Long id;
    private String serviceName;
    private double price;
    private int quantity;

    //constructors
    public CartItem() {}

    public CartItem(Long id, String serviceName, double price, int quantity) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.quantity = quantity;
    }

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
