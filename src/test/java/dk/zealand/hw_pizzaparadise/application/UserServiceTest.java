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
        userService.createUser(user);

        verify(userRepository).saveUser(user);
    }

    @Test
    void getUserById_withValidId_returnsUser() {
        when(userRepository.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);

        assertEquals("John", result.getName());
        assertEquals("john@email.com", result.getEmail());
    }

    @Test
    void getUserById_withInvalidId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> userService.getUserById(-1));
    }

    @Test
    void addBonusPoints_withValidUser_increasesBonusPoints() {
        when(userRepository.getUserById(1)).thenReturn(user);

        userService.addBonusPoints(1, 10);

        assertEquals(10, user.getBonusPoints());
        verify(userRepository).updateUser(user);
    }
}