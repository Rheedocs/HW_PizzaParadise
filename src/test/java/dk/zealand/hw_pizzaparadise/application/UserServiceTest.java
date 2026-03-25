package dk.zealand.hw_pizzaparadise.application;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.application.service.UserService;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.UserNotFoundException;
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

        assertDoesNotThrow(() -> {
            userService.createUser(user);
        });

        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("Vestergade 1", user.getAddress());
        assertEquals(0, user.getBonusPoints());

    }

    @Test
    void getUserById_withValidId_returnsUser() {
        // TODO: Test at en bruger hentes korrekt via id
        when(userRepository.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);

        assertEquals("John", result.getName());
        assertEquals("john@email.com", result.getEmail());

    }

    @Test
    void getUserById_withInvalidId_throwsUserNotFoundException() {
        // TODO: Test at UserNotFoundException kastes ved ugyldigt id

        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(-1);});

    }

    @Test
    void addBonusPoints_withValidUser_increasesBonusPoints() {
        // TODO: Test at bonuspoint tilføjes korrekt
        when(userRepository.getUserById(1)).thenReturn(user);

        assertDoesNotThrow(() -> userService.addBonusPoints(1, 10));

    }
}