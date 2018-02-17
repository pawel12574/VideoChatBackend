package corpchat.service;

import corpchat.model.User;

public interface UserService {

    void registerUser(User user);
    void updateUser(User user);

    User getLoggedUser();

}
