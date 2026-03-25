package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.EmptyOrderException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.InsufficientBonusPointsException;
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
public class OrderServiceTest {

    @Mock
    private IOrderRepository orderRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, "John", "john@email.com", "Vestergade 1");
        order = new Order(1, 1);
    }

    @Test
    void placeOrder_withValidOrder_savesOrder() {
        order.addPizza(new Pizza(1, "Margherita", "Classic Pizza", 79.0));
        when(userRepository.getUserById(1)).thenReturn(user);

        orderService.placeOrder(order);

        verify(orderRepository).saveOrder(order);
    }

    @Test
    void placeOrder_withEmptyOrder_throwsEmptyOrderException() {
        assertThrows(EmptyOrderException.class, () -> orderService.placeOrder(order));
    }

    @Test
    void placeOrder_withValidOrder_addsBonusPointsToUser() {
        order.addPizza(new Pizza(1, "Margherita", "Classic Pizza", 79.0));
        when(userRepository.getUserById(1)).thenReturn(user);

        orderService.placeOrder(order);

        verify(userRepository).updateUser(user);
        assertTrue(user.getBonusPoints() > 0);
    }

    @Test
    void getOrdersByUserId_withValidUser_returnsOrders() {
        when(orderRepository.getOrdersByUserId(1)).thenReturn(List.of(order));

        List<Order> result = orderService.getOrdersByUserId(1);

        assertEquals(1, result.size());
    }

    @Test
    void calculateDiscount_withInsufficientPoints_throwsException() {
        user.setBonusPoints(0);
        when(userRepository.getUserById(1)).thenReturn(user);

        assertThrows(InsufficientBonusPointsException.class, () -> orderService.calculateDiscount(1));
    }

    @Test
    void getOrderById_withValidId_returnsOrder() {
        when(orderRepository.getOrderById(1)).thenReturn(order);

        Order result = orderService.getOrderById(1);

        assertEquals(1, result.getId());
    }

    @Test
    void deleteOrder_withValidId_deletesOrder() {
        orderService.deleteOrder(1);

        verify(orderRepository).deleteOrder(1);
    }
}