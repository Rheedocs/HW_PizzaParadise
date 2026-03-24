package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        // TODO: Hent alle ordrer og send til view – return "order/order"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        // TODO: Hent ordre og send til view – return "order/order"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order) {
        // TODO: Placer ordre og redirect til ordrehistorik – return "redirect:/orders"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/user/{userId}")
    public String getOrdersByUserId(@PathVariable int userId, Model model) {
        // TODO: Hent alle ordrer for bruger og send til view – return "order/order-history"
        throw new UnsupportedOperationException("Not implemented yet");
    }
}