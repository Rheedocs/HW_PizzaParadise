package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public String getAllPizzas(Model model) {
        // TODO: Hent alle pizzaer og send til view – return "pizza/menu"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/custom")
    public String showCustomPizzaForm(Model model) {
        // TODO: Vis formular til at lave egen pizza – return "pizza/custom-pizza"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PostMapping("/custom")
    public String createCustomPizza(@ModelAttribute Pizza pizza) {
        // TODO: Opret custom pizza og redirect til menu – return "redirect:/pizzas"
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/{id}")
    public String getPizzaById(@PathVariable int id, Model model) {
        // TODO: Hent pizza og send til view – return "pizza/menu"
        throw new UnsupportedOperationException("Not implemented yet");
    }
}