package org.example.finmark_cartcheckout_micro.controller;

import org.example.finmark_cartcheckout_micro.model.CartItem;
import org.example.finmark_cartcheckout_micro.model.Order;
import org.example.finmark_cartcheckout_micro.model.PaymentInfo;
import org.example.finmark_cartcheckout_micro.service.CartService;
import org.example.finmark_cartcheckout_micro.service.CheckoutHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CheckoutHelper checkoutHelper;

    //1. Add to Cart
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String serviceName,
                            @RequestParam double price) {
        cartService.addItem(new CartItem(null, serviceName, price, 1));
        return "redirect:/cart/review";
    }

    //2. View Cart
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getItems());
        model.addAttribute("cartTotal", cartService.getTotal());
        return "cart"; // cart.html
    }

    // 3. Review Cart (cart_review.html)
    @GetMapping("/cart/review")
    public String reviewCart(Model model) {
        model.addAttribute("cartItems", cartService.getItems());
        model.addAttribute("cartTotal", cartService.getTotal());
        return "cart-review"; // cart_review.html
    }

    // 4. Remove Item
    @PostMapping("/cart/remove-item")
    public String removeItem(@RequestParam("itemIndex") int index) {
        cartService.removeItem(index);
        return "redirect:/cart/review";
    }

    // 5. Checkout Initiation (payment.html)
    @PostMapping("/cart/checkout")
    public String checkout(Model model) {
        model.addAttribute("totalAmount", cartService.getTotal());
        return "payment-gateway"; // payment.html
    }

    // 6. Process Payment → Confirmation (confirmation.html)
    @PostMapping("/cart/process-payment")
    public String processPayment(@RequestParam String cardHolderName,
                                 @RequestParam String cardNumber,
                                 Model model) {
        PaymentInfo payment = new PaymentInfo(cardHolderName, cardNumber, cartService.getTotal());

        Order order = checkoutHelper.buildOrder(cartService.getItems(), payment);

        model.addAttribute("payerName", order.getPayerName());
        model.addAttribute("refNumber", order.getRefNumber());
        model.addAttribute("orderSummary", order.getOrderSummary());
        model.addAttribute("totalAmount", order.getTotalAmount());

        cartService.clear(); // empty cart after successful checkout

        return "confirmation"; // confirmation.html
    }

}
