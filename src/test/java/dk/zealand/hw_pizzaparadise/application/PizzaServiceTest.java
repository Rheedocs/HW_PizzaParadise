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

import java.util.List;
import java.util.Optional;

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

        assertThrows(UnsupportedOperationException.class, () -> {
            pizzaService.getAllPizzas();
        });

        //stadig bevidst “forkert resultat”
        verify(pizzaRepository, never()).getAllPizzas();
    }

    @Test
    void getPizzaById_withValidId_returnsPizza() {
        when(pizzaRepository.getPizzaById(1)).thenReturn(pizza);

        assertThrows(UnsupportedOperationException.class, () -> {
            pizzaService.getPizzaById(1);
        });

        // bliver ikke kaldt endnu
        verify(pizzaRepository, never()).getPizzaById(1);
    }

    @Test
    void getPizzaById_withInvalidId_throwsPizzaNotFoundException() {
        when(pizzaRepository.getPizzaById(99)).thenReturn(null);

        assertThrows(UnsupportedOperationException.class, () -> {
            pizzaService.getPizzaById(99);
        });
    }

    @Test
    void createCustomPizza_withToppings_returnsCorrectPrice() {
        List<Topping> toppings = List.of(topping);

        doNothing().when(pizzaRepository).savePizza(any(Pizza.class));

        assertThrows(UnsupportedOperationException.class, () -> {
            pizzaService.createCustomPizza("Custom", "Test", 50.0, toppings);
        });

        verify(pizzaRepository, never()).savePizza(any(Pizza.class));
    }
}