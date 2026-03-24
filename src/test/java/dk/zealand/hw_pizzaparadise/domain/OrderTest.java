package dk.zealand.hw_pizzaparadise.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;
    private Pizza margherita;
    private Pizza pepperoni;

    @BeforeEach
    void setUp() {
        order = new Order(1, 1);
        margherita = new Pizza(1, "Margherita", "Classic pizza", 79.0);
        pepperoni = new Pizza(2, "Pepperoni", "Spicy pizza", 89.0);
    }

    @Test
    void calculateTotal_withNoPizzas_returnsZero() {
        double result = order.calculateTotal();
        assertEquals(0.0, result);
    }

    @Test
    void calculateTotal_withTwoPizzas_returnsCorrectTotal() {
        order.addPizza(margherita);
        order.addPizza(pepperoni);

        double result = order.calculateTotal();

        assertEquals(168.0, result);
    }
}