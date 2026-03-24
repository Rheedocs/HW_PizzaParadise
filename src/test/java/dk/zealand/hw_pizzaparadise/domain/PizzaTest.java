package dk.zealand.hw_pizzaparadise.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {

    private Pizza pizza;
    private Topping mozzarella;
    private Topping pepperoni;

    @BeforeEach
    void setUp() {
        pizza = new Pizza(1, "Margherita", "Classic pizza", 79.0);
        mozzarella = new Topping(1, "Mozzarella", 10.0);
        pepperoni = new Topping(2, "Pepperoni", 15.0);
    }

    @Test
    void calculatePrice_withNoToppings_returnsBasePrice() {
        double result = pizza.calculatePrice();
        assertEquals(79.0, result);
    }

    @Test
    void calculatePrice_withToppings_returnsBasePricePlusToppings() {
        pizza.addTopping(mozzarella);
        pizza.addTopping(pepperoni);

        double result = pizza.calculatePrice();

        assertEquals(104.0, result);
    }

    @Test
    void calculatePrice_afterRemovingTopping_returnsCorrectPrice() {
        pizza.addTopping(mozzarella);
        pizza.addTopping(pepperoni);

        pizza.removeTopping(pepperoni);
        double result = pizza.calculatePrice();

        assertEquals(89.0, result);
    }
}