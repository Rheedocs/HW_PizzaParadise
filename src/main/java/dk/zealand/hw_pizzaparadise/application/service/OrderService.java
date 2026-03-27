package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.EmptyOrderException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final IOrderRepository orderRepository;
    private final IUserRepository userRepository;

    public OrderService(IOrderRepository orderRepository, IUserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public void placeOrder(Order order) {
        if (order.getPizzas().isEmpty()) throw new EmptyOrderException();
        orderRepository.saveOrder(order);
        addBonusPointsToUser(order);
    }

    public void placeOrder(int userId, List<Integer> pizzaIds, boolean useBonusPoints) {
        List<Pizza> pizzas = orderRepository.getPizzasByIds(pizzaIds);
        Order order = new Order(0, userId);
        order.setPizzas(pizzas);
        if (useBonusPoints) applyDiscount(order, userId);
        placeOrder(order);
    }

    private void applyDiscount(Order order, int userId) {
        User user = userRepository.getUserById(userId);
        double discount = user.getBonusPoints();
        order.setDiscount(discount);
        user.setBonusPoints(0);
        userRepository.updateUser(user);
    }

    private void addBonusPointsToUser(Order order) {
        User user = userRepository.getUserById(order.getUserId());
        int pointsEarned = (int) (order.calculateTotal() / 10);
        user.addBonusPoints(pointsEarned);
        userRepository.updateUser(user);
    }

    public double getOrderTotal(int id) {
        return orderRepository.getOrderById(id).calculateTotal();
    }

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }
}