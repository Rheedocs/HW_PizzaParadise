package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.User;
import dk.zealand.hw_pizzaparadise.domain.exceptions.InsufficientBonusPointsException;
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
        if (user.getName() == null || user.getName().isBlank()){
            throw new IllegalArgumentException("User må ikke være tomt!");
        }
        if (user.getEmail() == null || user.getEmail().isBlank() && !user.getEmail().matches(".+@.+\\..+")){
            throw new IllegalArgumentException("Email må ikke være tomt og skal indeholde @ og (.)");
        }

        if (user.getAddress().length() > 50){
            throw new IllegalArgumentException("Addresse må ikke være længere end 50 tegn");
        }
        userRepository.saveUser(user);
    }

    public User getUserById(int id) {
        if (id <= 0){
            throw new UserNotFoundException("Id skal være større end 0");
        }

        User user = userRepository.getUserById(id);

        if (user == null){
            throw new UserNotFoundException("Bruger ikke fundet!");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email må ikke være tom");
        }

        User user = userRepository.getUserByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("Bruger med email " + email + " findes ikke");
        }

        return user;
    }

    public void updateUser(User user) {

        if (user == null) {
            throw new IllegalArgumentException("Bruger må ikke være null");
        }

        if (user.getId() <= 0) {
            throw new UserNotFoundException("Ugyldigt bruger-id");
        }

        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("Navn må ikke være tomt");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email må ikke være tom");
        }

        if (user.getAddress() == null || user.getAddress().isBlank()) {
            throw new IllegalArgumentException("Adresse må ikke være tom");
        }

        if (user.getAddress().length() > 50) {
            throw new IllegalArgumentException("Adresse må ikke være længere end 50 tegn");
        }

        userRepository.updateUser(user);
    }

    public void deleteUser(int id) {
        if (id <= 0){
            throw new IllegalArgumentException("Ugyldig bruger-id!");
        }

        User user = userRepository.getUserById(id);

        if (user == null){
            throw new UserNotFoundException("Bruger med id " + id + " findes ikke");
        }

        userRepository.deleteUser(id);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();

        if (users == null || users.isEmpty()) {
            throw new UserNotFoundException("Ingen brugere fundet i systemet");
        }

        return users;
    }

    public void addBonusPoints(int userId, int points) {
        // TODO: Tilføj bonuspoint til bruger
        if (points <= 0){
            throw new IllegalArgumentException("Point skal være større end 0!");
        }
        User user = userRepository.getUserById(userId);

        if (user == null) {
            throw new UserNotFoundException("Bruger ikke fundet");
        }

        user.addBonusPoints(points);
    }
}