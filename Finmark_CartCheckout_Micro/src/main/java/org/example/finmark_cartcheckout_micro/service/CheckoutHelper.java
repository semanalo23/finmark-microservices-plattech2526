package org.example.finmark_cartcheckout_micro.service;

import org.example.finmark_cartcheckout_micro.model.CartItem;
import org.example.finmark_cartcheckout_micro.model.Order;
import org.example.finmark_cartcheckout_micro.model.PaymentInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CheckoutHelper {

    public Order buildOrder(List<CartItem> items, PaymentInfo payment) {
        String refNumber = "FIN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        String summary = items.stream()
                .map(CartItem::getServiceName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No items");

        return new Order(payment.getCardHolderName(), refNumber, summary, payment.getAmount());
    }
}
