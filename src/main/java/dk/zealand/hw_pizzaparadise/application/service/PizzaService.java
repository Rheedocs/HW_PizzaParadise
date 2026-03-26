package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import dk.zealand.hw_pizzaparadise.domain.exceptions.PizzaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final IPizzaRepository pizzaRepository;

    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void savePizza(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Pizza må ikke være null");
        }
        pizzaRepository.savePizza(pizza);
    }

    public Pizza getPizzaById(int id) {
        Pizza pizza = pizzaRepository.getPizzaById(id);
        if (pizza == null) {
            throw new PizzaNotFoundException(id);
        }
        return pizza;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.getAllPizzas();
    }

    public void deletePizza(int id) {
        pizzaRepository.deletePizza(id);
    }

    public List<Topping> getAllToppings() {
        return pizzaRepository.getAllToppings();
    }

    public Pizza createCustomPizza(String name, String description, double basePrice, List<Topping> toppings) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty() || toppings == null || toppings.isEmpty()) {
            throw new IllegalArgumentException("Navn, beskrivelse og toppings må ikke være tomme");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Basispris skal være større end 0");
        }
        Pizza customPizza = new Pizza(0, name, description, basePrice);
        customPizza.setToppings(toppings);
        pizzaRepository.savePizza(customPizza);
        return customPizza;
    }
}