package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class PizzaNotFoundException extends RuntimeException {
    public PizzaNotFoundException(int id) {
        super("Pizza med id " + id + " blev ikke fundet");
    }
}