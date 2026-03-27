package dk.zealand.hw_pizzaparadise.infrastructure.mappers;

import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToppingRowMapper implements RowMapper<Topping> {
    @Override
    public Topping mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Topping(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price")
        );
    }
}