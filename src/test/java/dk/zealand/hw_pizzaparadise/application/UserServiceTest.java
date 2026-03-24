package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        // TODO: Opsæt UserService med mock repository
    }

    @Test
    void createUser_withValidUser_savesUser() {
        // TODO: Test at en bruger gemmes korrekt
    }

    @Test
    void getUserById_withValidId_returnsUser() {
        // TODO: Test at en bruger hentes korrekt via id
    }

    @Test
    void getUserById_withInvalidId_throwsUserNotFoundException() {
        // TODO: Test at UserNotFoundException kastes ved ugyldigt id
    }

    @Test
    void addBonusPoints_withValidUser_increasesBonusPoints() {
        // TODO: Test at bonuspoint tilføjes korrekt
    }
}