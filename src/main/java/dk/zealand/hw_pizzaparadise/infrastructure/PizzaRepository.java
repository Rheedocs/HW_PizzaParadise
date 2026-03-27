package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import dk.zealand.hw_pizzaparadise.infrastructure.mappers.PizzaRowMapper;
import dk.zealand.hw_pizzaparadise.infrastructure.mappers.ToppingRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class PizzaRepository implements IPizzaRepository {

    private final JdbcTemplate jdbcTemplate;
    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Pizza> pizzaRowMapper = new PizzaRowMapper();
    private final RowMapper<Topping> toppingRowMapper = new ToppingRowMapper();

    @Override
    public void savePizza(Pizza pizza) {
        String sql = "INSERT INTO pizzas (name, description, base_price, is_custom) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pizza.getName());
            ps.setString(2, pizza.getDescription());
            ps.setDouble(3, pizza.getBasePrice());
            ps.setBoolean(4, pizza.isCustom());
            return ps;
        }, keyHolder);
        pizza.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
    }

    @Override
    public Pizza getPizzaById(int id) {
        String sql = "SELECT * FROM pizzas WHERE id = ?";
        List<Pizza> result = jdbcTemplate.query(sql, pizzaRowMapper, id);
        return result.isEmpty() ? null : result.getFirst();
    }

    @Override
    public List<Pizza> getAllPizzas() {
        String sql = "SELECT * FROM pizzas WHERE is_custom = FALSE";
        return jdbcTemplate.query(sql, pizzaRowMapper);
    }

    @Override
    public void deletePizza(int id) {
        String sql = "DELETE FROM pizzas WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Topping> getAllToppings() {
        String sql = "SELECT * FROM toppings";
        return jdbcTemplate.query(sql, toppingRowMapper);
    }
}