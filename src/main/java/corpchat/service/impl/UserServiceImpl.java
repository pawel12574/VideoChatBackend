package corpchat.service.impl;


import corpchat.dao.UserRepository;
import corpchat.model.User;
import corpchat.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;
import corpchat.service.UserService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    PasswordEncoder encoder = PasswordEncoder.getInstance();

    String saltKey = "PveFT7isD==";

    public void registerUser(User user) throws IOException, NoSuchAlgorithmException {
        user.setPassword(encoder.encode(user.getPassword(), saltKey));
        userRepository.save(user);

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
