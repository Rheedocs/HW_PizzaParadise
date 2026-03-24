package dk.zealand.hw_pizzaparadise.application.interfaces;

import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import java.util.List;

public interface IPizzaRepository {
    void savePizza(Pizza pizza);
    Pizza getPizzaById(int id);
    List<Pizza> getAllPizzas();
    void deletePizza(int id);
    List<Topping> getAllToppings();
}