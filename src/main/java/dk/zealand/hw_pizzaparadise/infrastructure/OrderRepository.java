package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IOrderRepository;
import dk.zealand.hw_pizzaparadise.domain.Order;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.infrastructure.mappers.OrderRowMapper;
import dk.zealand.hw_pizzaparadise.infrastructure.mappers.PizzaRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderRepository implements IOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Order> orderRowMapper = new OrderRowMapper();
    private final RowMapper<Pizza> pizzaRowMapper = new PizzaRowMapper();

    public List<Pizza> getPizzasByIds(List<Integer> pizzaIds) {
        List<Pizza> pizzas = new ArrayList<>();
        for (int id : pizzaIds) {
            String sql = "SELECT * FROM pizzas WHERE id = ?";
            Pizza pizza = jdbcTemplate.queryForObject(sql, pizzaRowMapper, id);
            pizzas.add(pizza);
        }
        return pizzas;
    }

    @Override
    public void saveOrder(Order order) {
        int orderId = insertOrder(order);
        insertOrderPizzas(orderId, order.getPizzas());
    }

    private int insertOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, date, discount) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUserId());
            ps.setDate(2, Date.valueOf(order.getDate()));
            ps.setDouble(3, order.getDiscount());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    private void insertOrderPizzas(int orderId, List<Pizza> pizzas) {
        String sql = "INSERT INTO order_pizzas (order_id, pizza_id) VALUES (?, ?)";
        for (Pizza pizza : pizzas) jdbcTemplate.update(sql, orderId, pizza.getId());
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        Order order = jdbcTemplate.queryForObject(sql, orderRowMapper, id);
        order.setPizzas(getPizzasForOrder(id));
        return order;
    }

    private List<Pizza> getPizzasForOrder(int orderId) {
        String sql = "SELECT p.* FROM pizzas p JOIN order_pizzas op ON p.id = op.pizza_id WHERE op.order_id = ?";
        return jdbcTemplate.query(sql, pizzaRowMapper, orderId);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        List<Order> orders = jdbcTemplate.query(sql, orderRowMapper, userId);
        for (Order order : orders) order.setPizzas(getPizzasForOrder(order.getId()));
        return orders;
    }

    @Override
    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}