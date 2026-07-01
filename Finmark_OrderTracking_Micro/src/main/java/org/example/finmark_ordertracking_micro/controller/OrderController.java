package org.example.finmark_ordertracking_micro.controller;

import org.example.finmark_ordertracking_micro.model.OrderModel;
import org.example.finmark_ordertracking_micro.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OrderController {

    private final OrderService orderService;

    //constructor
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/track")
    public String trackOrder(@RequestParam(value="referenceNumber", required=false) String referenceNumber, Model model) {
        if (referenceNumber != null) {
            Optional<OrderModel> order = orderService.findByReferenceNumber(referenceNumber);
            if (order.isPresent()) {
                model.addAttribute("orderFound", order.get());
            } else {
                model.addAttribute("errorSearching", true);
            }
            model.addAttribute("searchedRef", referenceNumber);
        }
        return "order-tracking";
    }
}
