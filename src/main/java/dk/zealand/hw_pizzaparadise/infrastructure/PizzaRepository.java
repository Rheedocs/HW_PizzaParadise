package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository {

    @Override
    public void savePizza(Pizza pizza) {
        // TODO: Gem pizza i databasen via JDBC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Pizza getPizzaById(int id) {
        // TODO: Hent pizza fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Pizza> getAllPizzas() {
        // TODO: Hent alle pizzaer fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deletePizza(int id) {
        // TODO: Slet pizza fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Topping> getAllToppings() {
        // TODO: Hent alle toppings fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }
}