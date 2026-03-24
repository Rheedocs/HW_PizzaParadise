package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        // TODO: Opsæt OrderService med mock repositories
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