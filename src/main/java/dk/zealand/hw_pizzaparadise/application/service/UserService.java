package dk.zealand.hw_pizzaparadise.application.service;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        // TODO: Opret en ny bruger og gem i databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public User getUserById(int id) {
        // TODO: Hent bruger baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public User getUserByEmail(String email) {
        // TODO: Hent bruger baseret på email
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void updateUser(User user) {
        // TODO: Opdater eksisterende bruger i databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void deleteUser(int id) {
        // TODO: Slet bruger baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<User> getAllUsers() {
        // TODO: Hent alle brugere fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addBonusPoints(int userId, int points) {
        // TODO: Tilføj bonuspoint til bruger
        throw new UnsupportedOperationException("Not implemented yet");
    }
}