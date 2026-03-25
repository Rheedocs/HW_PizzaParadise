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
        // TODO: Erstat 1 med den faktiske logged-in brugers id
        model.addAttribute("orders", orderService.getOrdersByUserId(1));
        return "order/order";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "order/order";
    }

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order) {
        orderService.placeOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/user/{userId}")
    public String getOrdersByUserId(@PathVariable int userId, Model model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        return "order/order-history";
    }
}