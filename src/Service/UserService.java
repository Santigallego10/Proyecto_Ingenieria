package Service;

import dominio.User;
import interfaces.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String id, String name) {
        User user = new User(id, name);
        userRepository.save(user);
    }

    public User getUser(String id) {
        return userRepository.findById(id);
    }
}

