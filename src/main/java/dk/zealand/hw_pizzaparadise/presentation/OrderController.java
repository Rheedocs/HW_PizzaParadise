package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.domain.Order;
import jakarta.servlet.http.HttpSession;
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
    public String getAllOrders(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) return "redirect:/users/login";
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        return "order/order-history";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("total", orderService.getOrderTotal(id));
        return "order/order";
    }

    @PostMapping("/place")
    public String placeOrder(@ModelAttribute Order order) {
        orderService.placeOrder(order);
        return "redirect:/orders";
    }
}