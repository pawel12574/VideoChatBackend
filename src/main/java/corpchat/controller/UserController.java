package corpchat.controller;

import corpchat.dao.UserRepository;
import corpchat.model.User;
import corpchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = POST)
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

    @RequestMapping(value = "/find/{email:.+}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User getUserByEmail(@PathVariable("email") String email){
        return userRepository.findByEmail(email);
    }

    @RequestMapping(value = "/addFriend/{id}", method = GET) //friend id
    public void addFriend(@PathVariable("id") Long id){
         User friend = userRepository.findOne(id);
         User loggedIn = userService.getLoggedUser();
         loggedIn.getFriend().add(friend);
         userRepository.save(loggedIn);
    }

    @RequestMapping(value = "/getFriend/", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User getFriends(){
        return userRepository.userWithFriends(userService.getLoggedUser().getEmail());
    }




}
