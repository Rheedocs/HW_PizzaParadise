package dk.zealand.hw_pizzaparadise.domain;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private int id;
    private String name;
    private String description;
    private double basePrice;
    private List<Topping> toppings;

    public Pizza(int id, String name, String description, double basePrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.toppings = new ArrayList<>();
    }
    public Pizza(){
        this.toppings = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getBasePrice() { return basePrice; }
    public List<Topping> getToppings() { return toppings; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
    public void setToppings(List<Topping> toppings) { this.toppings = toppings; }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        this.toppings.remove(topping);
    }

    public double calculatePrice() {
        double total = basePrice;
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }
}