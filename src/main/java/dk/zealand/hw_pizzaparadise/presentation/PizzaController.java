package dk.zealand.hw_pizzaparadise.presentation;

import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    // Henter alle pizzaer (matcher getAllPizzas fra repo)
    @GetMapping
    public String getAllPizzas(Model model) {
        List<Pizza> pizzas = pizzaService.getAllPizzas();

        model.addAttribute("pizzas", pizzas);

        return "pizza/menu";
    }

    // ✅ Viser form + toppings (matcher getAllToppings fra repo)
    @GetMapping("/custom")
    public String showCustomPizzaForm(Model model) {
        model.addAttribute("pizza", new Pizza());

        List<Topping> toppings = pizzaService.getAllToppings();
        model.addAttribute("toppings", toppings);

        return "pizza/custom-pizza";
    }

    // ✅ Opretter custom pizza korrekt
    @PostMapping("/custom")
    public String createCustomPizza(@ModelAttribute Pizza pizza,
                                    @RequestParam(required = false) List<Integer> toppingIds) {

        // Hent ALLE toppings fra DB
        List<Topping> allToppings = pizzaService.getAllToppings();

        // Filtrer kun de valgte toppings
        List<Topping> selectedToppings = allToppings.stream()
                .filter(t -> toppingIds != null && toppingIds.contains(t.getId()))
                .toList();

        // ⚠️ VIGTIGT: brug korrekt service metode (med basePrice!)
        pizzaService.createCustomPizza(
                pizza.getName(),
                pizza.getDescription(),
                pizza.getBasePrice(),
                selectedToppings
        );

        return "redirect:/pizzas";
    }

    // ✅ Henter pizza via ID (matcher repo)
    @GetMapping("/{id}")
    public String getPizzaById(@PathVariable int id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);

        model.addAttribute("pizza", pizza);

        return "pizza/menu"; // evt. lav separat detail-side senere
    }
}