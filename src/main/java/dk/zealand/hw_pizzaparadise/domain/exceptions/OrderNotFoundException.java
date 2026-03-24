package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(int id) {
        super("Ordre med id " + id + " blev ikke fundet");
    }
}