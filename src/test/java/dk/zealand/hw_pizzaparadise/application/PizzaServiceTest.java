package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaServiceTest {

    private PizzaService pizzaService;

    @BeforeEach
    void setUp() {
        // TODO: Opsæt PizzaService med mock repository
    }

    @Test
    void getAllPizzas_returnsAllPizzas() {
        // TODO: Test at alle pizzaer hentes korrekt
    }

    @Test
    void getPizzaById_withValidId_returnsPizza() {
        // TODO: Test at en pizza hentes korrekt via id
    }

    @Test
    void getPizzaById_withInvalidId_throwsPizzaNotFoundException() {
        // TODO: Test at PizzaNotFoundException kastes ved ugyldigt id
    }

    @Test
    void createCustomPizza_withToppings_returnsCorrectPrice() {
        // TODO: Test at en custom pizza oprettes med korrekt pris
    }
}