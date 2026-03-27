package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import dk.zealand.hw_pizzaparadise.domain.exceptions.PizzaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    private final IPizzaRepository pizzaRepository;

    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void savePizza(Pizza pizza) {
        if (pizza == null) throw new IllegalArgumentException("Pizza må ikke være null");
        pizzaRepository.savePizza(pizza);
    }

    public Pizza getPizzaById(int id) {
        if (id <= 0) throw new IllegalArgumentException("Id skal være større end 0");
        Pizza pizza = pizzaRepository.getPizzaById(id);
        if (pizza == null) throw new PizzaNotFoundException(id);
        return pizza;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    public void deletePizza(int id) {
        if (id <= 0) throw new IllegalArgumentException("Ugyldigt pizza-id");
        pizzaRepository.deletePizza(id);
    }

    public List<Topping> getAllToppings() {
        return pizzaRepository.getAllToppings();
    }

    public Pizza createCustomPizza(List<Integer> toppingIds) {
        List<Topping> selectedToppings = getToppingsByIds(toppingIds);
        String description = buildDescription(selectedToppings);
        double totalPrice = calculateTotalPrice(selectedToppings);
        Pizza customPizza = new Pizza(0, "Egen pizza", description, totalPrice);
        customPizza.setCustom(true);
        customPizza.setToppings(selectedToppings);
        pizzaRepository.savePizza(customPizza);
        return customPizza;
    }

    private double calculateTotalPrice(List<Topping> toppings) {
        double total = 40.0;
        for (Topping t : toppings) total += t.getPrice();
        return total;
    }

    private String buildDescription(List<Topping> toppings) {
        if (toppings.isEmpty()) return "Pizza uden toppings";
        List<String> names = new ArrayList<>();
        for (Topping t : toppings) names.add(t.getName());
        return "Pizza med " + String.join(", ", names);
    }

    private List<Topping> getToppingsByIds(List<Integer> toppingIds) {
        if (toppingIds == null) return new ArrayList<>();
        List<Topping> selectedToppings = new ArrayList<>();
        for (Topping t : pizzaRepository.getAllToppings()) if (toppingIds.contains(t.getId())) selectedToppings.add(t);
        return selectedToppings;
    }
}