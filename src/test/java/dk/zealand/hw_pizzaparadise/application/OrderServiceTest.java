package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        // TODO: Test at en ordre gemmes korrekt
    }

    @Test
    void placeOrder_withEmptyOrder_throwsEmptyOrderException() {
        // TODO: Test at EmptyOrderException kastes ved tom ordre
    }

    @Test
    void getOrdersByUserId_withValidUser_returnsOrders() {
        // TODO: Test at ordrer hentes korrekt for en bruger
    }

    @Test
    void calculateDiscount_withInsufficientPoints_throwsException() {
        // TODO: Test at InsufficientBonusPointsException kastes
    }
}