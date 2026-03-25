package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, date) VALUES (?, ?)";
        jdbcTemplate.update(sql, order.getUserId(), order.getDate());
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Order order = new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id")
            );
            order.setDate(rs.getDate("date").toLocalDate());
            return order;
        }, id);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order(
                    rs.getInt("id"),
                    rs.getInt("user_id")
            );
            order.setDate(rs.getDate("date").toLocalDate());
            return order;
        }, userId);
    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}