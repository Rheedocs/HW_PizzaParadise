package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.application.service.UserService;
import dk.zealand.hw_pizzaparadise.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final PizzaService pizzaService;
    private final UserService userService;

    public OrderController(OrderService orderService, PizzaService pizzaService, UserService userService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
        this.userService = userService;
    }

    @GetMapping("/place/{userId}")
    public String showPlaceOrderForm(@PathVariable int userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        model.addAttribute("bonusPoints", userService.getUserById(userId).getBonusPoints());
        return "order/place-order";
    }

    @PostMapping("/place/{userId}")
    public String placeOrder(@PathVariable int userId,
                             @RequestParam List<Integer> pizzaIds,
                             @RequestParam(required = false, defaultValue = "false") boolean useBonusPoints) {
        orderService.placeOrder(userId, pizzaIds, useBonusPoints);
        return "redirect:/orders/user/" + userId;
    }

    @GetMapping("/user/{userId}")
    public String getOrdersByUserId(@PathVariable int userId, Model model) {
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        return "order/order-history";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("total", orderService.getOrderTotal(id));
        return "order/order";
    }
}