package dk.zealand.hw_pizzaparadise.infrastructure;

import dk.zealand.hw_pizzaparadise.application.interfaces.IUserRepository;
import dk.zealand.hw_pizzaparadise.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @Override
    public void saveUser(User user) {
        // TODO: Gem bruger i databasen via JDBC
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public User getUserById(int id) {
        // TODO: Hent bruger fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public User getUserByEmail(String email) {
        // TODO: Hent bruger fra databasen baseret på email
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void updateUser(User user) {
        // TODO: Opdater bruger i databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteUser(int id) {
        // TODO: Slet bruger fra databasen baseret på id
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO: Hent alle brugere fra databasen
        throw new UnsupportedOperationException("Not implemented yet");
    }
}