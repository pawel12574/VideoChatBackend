package corpchat.service;

import corpchat.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    User findByEmail(String email);
    User getUserWithFriends();
    void save(User user);
    void registerUser(User user);
    void updateUser(User user);
    User getLoggedUser();
    String getLoggedUsername();

}
