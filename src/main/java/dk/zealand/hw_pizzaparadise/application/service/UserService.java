package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        validateUser(user);
        userRepository.saveUser(user);
    }

    private void validateUser(User user) {
        if (user == null) throw new IllegalArgumentException("Bruger må ikke være null");
        if (user.getName() == null || user.getName().isBlank()) throw new IllegalArgumentException("Navn må ikke være tomt");
        if (user.getEmail() == null || user.getEmail().isBlank() || !user.getEmail().matches(".+@.+\\..+"))
            throw new IllegalArgumentException("Email må ikke være tom og skal indeholde @ og punktum");
        if (user.getAddress() == null || user.getAddress().isBlank()) throw new IllegalArgumentException("Adresse må ikke være tom");
        if (user.getAddress().length() > 50) throw new IllegalArgumentException("Adresse må ikke være længere end 50 tegn");
    }

    public User getUserById(int id) {
        if (id <= 0) throw new IllegalArgumentException("Id skal være større end 0");
        User user = userRepository.getUserById(id);
        if (user == null) throw new UserNotFoundException(id);
        return user;
    }

    public User getUserByEmail(String email) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email må ikke være tom");
        User user = userRepository.getUserByEmail(email);
        if (user == null) throw new UserNotFoundException(email);
        return user;
    }

    public void updateUser(User user) {
        validateUser(user);
        userRepository.updateUser(user);
    }

    public void deleteUser(int id) {
        if (id <= 0) throw new IllegalArgumentException("Ugyldigt bruger-id");
        User user = userRepository.getUserById(id);
        if (user == null) throw new UserNotFoundException(id);
        userRepository.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void addBonusPoints(int userId, int points) {
        if (points <= 0) throw new IllegalArgumentException("Point skal være større end 0");
        User user = userRepository.getUserById(userId);
        if (user == null) throw new UserNotFoundException(userId);
        user.addBonusPoints(points);
        userRepository.updateUser(user);
    }
}