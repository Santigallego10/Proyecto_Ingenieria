package interfaces;

import dominio.User;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}

