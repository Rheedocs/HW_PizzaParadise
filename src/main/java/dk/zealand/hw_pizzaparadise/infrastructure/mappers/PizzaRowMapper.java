package dk.zealand.hw_pizzaparadise.infrastructure.mappers;

import dk.zealand.hw_pizzaparadise.domain.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaRowMapper implements RowMapper<Pizza> {
    @Override
    public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pizza pizza = new Pizza(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("base_price")
        );
        pizza.setCustom(rs.getBoolean("is_custom"));
        return pizza;
    }
}