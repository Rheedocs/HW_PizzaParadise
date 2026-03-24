package dk.zealand.hw_pizzaparadise.domain.exceptions;

public class InsufficientBonusPointsException extends RuntimeException {
    public InsufficientBonusPointsException(int available, int required) {
        super("Ikke nok bonuspoint. Har " + available + ", mangler " + required);
    }
}