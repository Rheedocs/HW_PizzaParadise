package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IPizzaRepository;
import dk.zealand.hw_pizzaparadise.domain.Pizza;
import dk.zealand.hw_pizzaparadise.domain.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🔹 RowMapper til Pizza
    private final RowMapper<Pizza> pizzaRowMapper = (rs, rowNum) ->
            new Pizza(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price")
            );

    // 🔹 RowMapper til Topping
    private final RowMapper<Topping> toppingRowMapper = (rs, rowNum) ->
            new Topping(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price")
            );

    @Override
    public void savePizza(Pizza pizza) {
        String sql = "INSERT INTO pizzas (name, description, price) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,
                pizza.getName(),
                pizza.getDescription(),
                pizza.getBasePrice()
        );
    }

    @Override
    public Pizza getPizzaById(int id) {
        String sql = "SELECT * FROM pizzas WHERE id = ?";

        List<Pizza> result = jdbcTemplate.query(sql, pizzaRowMapper, id);

        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        String sql = "SELECT * FROM pizzas";

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