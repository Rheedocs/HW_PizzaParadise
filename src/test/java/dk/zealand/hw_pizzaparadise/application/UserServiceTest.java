package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.application.service.UserService;
import dk.zealand.hw_pizzaparadise.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, "John", "john@email.com", "Vestergade 1");
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