package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

    @Mock
    private IPizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaService pizzaService;

    private Pizza pizza;
    private Topping topping;

    @BeforeEach
    void setUp() {
        pizza = new Pizza(1, "Margherita", "Classic pizza", 79.0);
        topping = new Topping(1, "Mozzarella", 10.0);
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