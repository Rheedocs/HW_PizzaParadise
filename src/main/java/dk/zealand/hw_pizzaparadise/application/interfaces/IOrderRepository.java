package dk.zealand.hw_pizzaparadise.application.interfaces;

import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.Pizza;

import java.util.List;

public interface IOrderRepository {
    List<Pizza> getPizzasByIds(List<Integer> pizzaIds);
    void saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getOrdersByUserId(int userId);
    void deleteOrder(int id);
}