package dk.zealand.hw_pizzaparadise.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private LocalDate date;
    private List<Pizza> pizzas;

    public Order(int id, int userId) {
        this.id = id;
        this.userId = userId;
        this.date = LocalDate.now();
        this.pizzas = new ArrayList<>();
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public LocalDate getDate() { return date; }
    public List<Pizza> getPizzas() { return pizzas; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setPizzas(List<Pizza> pizzas) { this.pizzas = pizzas; }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public double calculateTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }
        return total;
    }
}