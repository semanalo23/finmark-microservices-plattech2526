package org.example.finmark_ordertracking_micro.service;

import org.example.finmark_ordertracking_micro.model.OrderModel;
import org.example.finmark_ordertracking_micro.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepo orderRepository;

    // Constructor
    public OrderService(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Track order by reference number
    public Optional<OrderModel> findByReferenceNumber(String referenceNumber) {
        return orderRepository.findByReferenceNumber(referenceNumber);
    }

    // Save new order (for testing or seeding data)
    public OrderModel saveOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    // List all orders (optional, useful for admin views)
    public Iterable<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }
}
