package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.application.service.PizzaService;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import dk.zealand.hw_pizzaparadise.domain.exceptions.PizzaNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
        when(pizzaRepository.getAllPizzas()).thenReturn(List.of(pizza));

        List<Pizza> result = pizzaService.getAllPizzas();

        assertEquals(1, result.size());
        verify(pizzaRepository, times(1)).getAllPizzas();
    }

    @Test
    void getPizzaById_withValidId_returnsPizza() {
        when(pizzaRepository.getPizzaById(1)).thenReturn(pizza);

        Pizza result = pizzaService.getPizzaById(1);

        assertEquals(pizza, result);
        verify(pizzaRepository, times(1)).getPizzaById(1);
    }

    @Test
    void getPizzaById_withInvalidId_throwsPizzaNotFoundException() {
        when(pizzaRepository.getPizzaById(99)).thenReturn(null);

        assertThrows(PizzaNotFoundException.class, () -> pizzaService.getPizzaById(99));
    }

    @Test
    void createCustomPizza_withToppings_returnsCorrectPrice() {
        when(pizzaRepository.getAllToppings()).thenReturn(List.of(topping));
        doNothing().when(pizzaRepository).savePizza(any(Pizza.class));

        Pizza result = pizzaService.createCustomPizza(List.of(1));

        assertEquals("Egen pizza", result.getName());
        assertEquals("Pizza med Mozzarella", result.getDescription());
        assertEquals(50, result.getBasePrice());
        verify(pizzaRepository, times(1)).savePizza(any(Pizza.class));
    }
}