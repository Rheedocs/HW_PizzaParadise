package dk.zealand.hw_pizzaparadise.infrastructure.mappers;

import dk.zealand.hw_pizzaparadise.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("address")
        );
        user.setBonusPoints(rs.getInt("bonus_points"));
        return user;
    }
}