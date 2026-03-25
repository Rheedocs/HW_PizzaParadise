package dk.zealand.hw_pizzaparadise.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(1, "John Doe", "john@email.com", "Vestergade 1");
    }

    @Test
    void newUser_hasZeroBonusPoints() {
        assertEquals(0, user.getBonusPoints());
    }

    @Test
    void addBonusPoints_increasesTotal() {
        user.addBonusPoints(10);

        assertEquals(10, user.getBonusPoints());
    }

    @Test
    void addBonusPoints_multipleTimes_accumulatesCorrectly() {
        user.addBonusPoints(10);
        user.addBonusPoints(25);

        assertEquals(35, user.getBonusPoints());
    }
    @Test
    void passwordIsHidden(){
        String result = user.toString();
        assertFalse(result.contains("1234"));
    }

}