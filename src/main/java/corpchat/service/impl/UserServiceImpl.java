package corpchat.service.impl;


import corpchat.dao.UserRepository;
import corpchat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import corpchat.service.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepositoryo.save(user);

    }
    public void updateUser(User user) {
        userRepository.save(user);
    }


    public User getLoggedUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        System.out.println(username);
        return userRepository.findByEmail(username);
    }
}
