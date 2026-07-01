package org.example.finmark_ordertracking_micro.repo;

import org.example.finmark_ordertracking_micro.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<OrderModel, Long> {

    // Custom finder method to search by reference number
    Optional<OrderModel> findByReferenceNumber(String referenceNumber);

}
