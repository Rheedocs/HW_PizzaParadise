package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
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
        // TODO: Gem ordre og tildel bonuspoint til bruger
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Order getOrderById(int id) {
        // TODO: Hent ordre baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Order> getOrdersByUserId(int userId) {
        // TODO: Hent alle ordrer for en bestemt bruger
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteOrder(int id) {
        // TODO: Slet ordre baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public double calculateDiscount(int userId) {
        // TODO: Beregn rabat baseret på brugerens bonuspoint
        throw new UnsupportedOperationException("Not implemented yet");
    }
}