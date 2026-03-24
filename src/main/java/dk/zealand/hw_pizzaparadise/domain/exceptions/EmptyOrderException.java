package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class EmptyOrderException extends RuntimeException {
    public EmptyOrderException() {
        super("En ordre skal indeholde mindst én pizza");
    }
}