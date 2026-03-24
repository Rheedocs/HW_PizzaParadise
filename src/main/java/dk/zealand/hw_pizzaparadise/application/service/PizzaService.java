package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final IPizzaRepository pizzaRepository;

    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void savePizza(Pizza pizza) {
        // TODO: Gem pizza i databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Pizza getPizzaById(int id) {
        // TODO: Hent pizza baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Pizza> getAllPizzas() {
        // TODO: Hent alle pizzaer fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deletePizza(int id) {
        // TODO: Slet pizza baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Topping> getAllToppings() {
        // TODO: Hent alle toppings fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Pizza createCustomPizza(String name, String description, double basePrice, List<Topping> toppings) {
        // TODO: Opret en custom pizza med valgte toppings
        throw new UnsupportedOperationException("Not implemented yet");
    }
}