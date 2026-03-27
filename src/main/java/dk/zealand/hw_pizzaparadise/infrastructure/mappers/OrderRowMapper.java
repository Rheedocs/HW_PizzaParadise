package dk.zealand.hw_pizzaparadise.infrastructure.mappers;

import dk.zealand.hw_pizzaparadise.domain.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order(
                rs.getInt("id"),
                rs.getInt("user_id")
        );
        order.setDate(rs.getDate("date").toLocalDate());
        order.setDiscount(rs.getDouble("discount"));
        return order;
    }
}