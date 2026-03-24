package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class InvalidToppingException extends RuntimeException {
    public InvalidToppingException(int id) {
        super("Topping med id " + id + " er ugyldig eller findes ikke");
    }
}