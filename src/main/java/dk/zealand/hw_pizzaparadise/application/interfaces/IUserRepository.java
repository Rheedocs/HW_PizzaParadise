package dk.zealand.hw_pizzaparadise.application.interfaces;

import dk.zealand.hw_pizzaparadise.domain.User;
import java.util.List;

public interface IUserRepository {
    void saveUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}