package util;

import dominio.User;
import interfaces.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
