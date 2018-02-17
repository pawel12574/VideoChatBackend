package corpchat.controller;

import corpchat.dao.UserRepository;
import corpchat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = GET)
    public @ResponseBody User registerUser(){
        System.out.println("register");
        User user = new User();
        user.setEmail("pawel@pawel.pl");
        user.setPassword("222");
        return userRepository.save(user);
    }

    @RequestMapping(value = "/find", method = GET)
    public User getUserByEmail(){
        return userRepository.findByEmail("pawel@pawel.pl");
    }
}
