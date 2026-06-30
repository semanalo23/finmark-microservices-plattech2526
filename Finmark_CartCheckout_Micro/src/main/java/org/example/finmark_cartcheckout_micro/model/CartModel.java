package org.example.finmark_cartcheckout_micro.model;

import java.util.ArrayList;
import java.util.List;

public class CartModel {

    private Long id;
    private List<CartItem> items = new ArrayList<>();
    private double total;

    //constructor
    public CartModel() {}

    public CartModel(Long id) {
        this.id = id;
    }

    //getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    //other utility methods
    public void addItem(CartItem item) {
        items.add(item);
        recalculateTotal();
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            recalculateTotal();
        }
    }

    public void clear() {
        items.clear();
        total = 0.0;
    }

    private void recalculateTotal() {
        total = items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }
}

