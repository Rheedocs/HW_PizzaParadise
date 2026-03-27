package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.application.service.UserService;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;
    private final OrderService orderService;
    private final UserService userService;

    public PizzaController(PizzaService pizzaService, OrderService orderService, UserService userService) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "pizza/menu";
    }

    @GetMapping("/custom")
    public String showCustomPizzaForm(@RequestParam(required = false) Integer userId, Model model) {
        model.addAttribute("toppings", pizzaService.getAllToppings());
        model.addAttribute("userId", userId);
        if (userId != null) model.addAttribute("bonusPoints", userService.getUserById(userId).getBonusPoints());
        return "pizza/custom-pizza";
    }

    @PostMapping("/custom")
    public String createCustomPizza(@RequestParam(required = false) List<Integer> toppingIds,
                                    @RequestParam(required = false) Integer userId,
                                    @RequestParam(required = false, defaultValue = "false") boolean useBonusPoints) {
        Pizza customPizza = pizzaService.createCustomPizza(toppingIds);
        if (userId != null) {
            orderService.placeOrder(userId, List.of(customPizza.getId()), useBonusPoints);
            return "redirect:/orders/user/" + userId;
        }
        return "redirect:/pizzas";
    }

    @GetMapping("/{id}")
    public String getPizzaById(@PathVariable int id, Model model) {
        model.addAttribute("pizza", pizzaService.getPizzaById(id));
        return "pizza/detail";
    }
}