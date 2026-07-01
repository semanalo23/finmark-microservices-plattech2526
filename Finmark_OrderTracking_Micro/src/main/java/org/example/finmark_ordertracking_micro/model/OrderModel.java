package org.example.finmark_ordertracking_micro.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceNumber;
    private String servicesOrdered;
    private Double totalBill;
    private String status;

    // Constructors
    public OrderModel() {}

    public OrderModel(String referenceNumber, String servicesOrdered, Double totalBill, String status) {
        this.referenceNumber = referenceNumber;
        this.servicesOrdered = servicesOrdered;
        this.totalBill = totalBill;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getReferenceNumber() { return referenceNumber; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }

    public String getServicesOrdered() { return servicesOrdered; }
    public void setServicesOrdered(String servicesOrdered) { this.servicesOrdered = servicesOrdered; }

    public Double getTotalBill() { return totalBill; }
    public void setTotalBill(Double totalBill) { this.totalBill = totalBill; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
