package corpchat.service;

import corpchat.model.User;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    void registerUser(User user) throws IOException, NoSuchAlgorithmException;
    void updateUser(User user);

    User getLoggedUser();

}
