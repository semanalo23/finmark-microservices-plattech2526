package org.example.finmark_cartcheckout_micro.service;

import org.example.finmark_cartcheckout_micro.model.CartItem;
import org.example.finmark_cartcheckout_micro.model.CartModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartModel cart = new CartModel();

    //retrieve items
    public List<CartItem> getItems() {
        return cart.getItems();
    }

    //retrieve total
    public double getTotal() {
        return cart.getTotal();
    }

    //add item
    public void addItem(CartItem item) {
        cart.addItem(item);
    }

    //remove item
    public void removeItem(int index) {
        cart.removeItem(index);
    }

    //clear cart
    public void clear() {
        cart.clear();
    }

}
