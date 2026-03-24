package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository {

    @Override
    public void saveOrder(Order order) {
        // TODO: Gem ordre i databasen via JDBC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Order getOrderById(int id) {
        // TODO: Hent ordre fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        // TODO: Hent alle ordrer for en bestemt bruger
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteOrder(int id) {
        // TODO: Slet ordre fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }
}