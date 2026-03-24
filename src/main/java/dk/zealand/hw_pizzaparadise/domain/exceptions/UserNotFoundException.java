package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("Bruger med id " + id + " blev ikke fundet");
    }

    public UserNotFoundException(String email) {
        super("Bruger med email " + email + " blev ikke fundet");
    }
}