package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.EmptyOrderException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.InsufficientBonusPointsException;
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
        if (order.getPizzas().isEmpty()) {
            throw new EmptyOrderException();
        }
        orderRepository.saveOrder(order);
        addBonusPointsToUser(order);
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

    // TODO: Bruges når bonuspoint integreres i bestillingsflowet
    public double calculateDiscount(int userId) {
        User user = userRepository.getUserById(userId);
        if (user.getBonusPoints() <= 0) {
            throw new InsufficientBonusPointsException(user.getBonusPoints(), 1);
        }
        return user.getBonusPoints() * 0.1;
    }
}