package dk.zealand.hw_pizzaparadise.presentation.exceptions;

import dk.zealand.hw_pizzaparadise.domain.exceptions.UserNotFoundException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.PizzaNotFoundException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.OrderNotFoundException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.EmptyOrderException;
import dk.zealand.hw_pizzaparadise.domain.exceptions.InsufficientBonusPointsException;
import dk.zealand.hw_pizzaparadise.infrastructure.exceptions.DatabaseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFound(UserNotFoundException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(PizzaNotFoundException.class)
    public String handlePizzaNotFound(PizzaNotFoundException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public String handleOrderNotFound(OrderNotFoundException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(EmptyOrderException.class)
    public String handleEmptyOrder(EmptyOrderException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(InsufficientBonusPointsException.class)
    public String handleInsufficientBonusPoints(InsufficientBonusPointsException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }

    @ExceptionHandler(DatabaseException.class)
    public String handleDatabaseException(DatabaseException ex, Model model) {
        model.addAttribute("fejl", List.of(ex.getMessage()));
        return "error";
    }
}