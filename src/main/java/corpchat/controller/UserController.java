package corpchat.controller;

import corpchat.dao.UserRepository;
import corpchat.model.User;
import corpchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    //String saltKey = "PveFT7isD==";

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

//    @RequestMapping(value="/log", method = POST)
//    public @ResponseBody boolean login(@RequestBody User user){
//        User userFromDb = userRepository.findByEmail(user.getEmail());
//        user.setPassword(encoder.encode(user.getPassword()));
//        System.out.println(userFromDb.getPassword()+" : " +user.getPassword());
//
//        return userFromDb.getPassword().equals(user.getPassword());
//
//    }

    @RequestMapping(value = "/register", method = POST)
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User fromDb = userService.findByEmail(user.getEmail());
        if (fromDb == null) {
            userService.registerUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/find/{email:.+}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUserByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/searchFriend/{friend:.+}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User searchFriendByEmail(@PathVariable("friend") String friend){
        User logged = userService.getLoggedUser();
        User user = userService.findByEmail(friend);
        if(user == null || logged.getFriend().contains(user)) return null;

        if(user.getEmail().equals(logged)) {
            return null;
        }
            else
            return user;

    }

    @RequestMapping(value = "/addFriend/{friendUsername:.+}", method = GET)
    public ResponseEntity<String> addFriend(@PathVariable("friendUsername") String friendUsername){
         User logged = userService.getLoggedUser();
         User friend = userService.getUserWithFriends();
         logged.getFriend().add(friend);
         friend.getFriend().add(logged);
         userService.save(logged);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getFriends", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Set<User> getFriends(){

        return userService.getUserWithFriends().getFriend();
    }

    @RequestMapping(value = "/getloggedUser", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUser(){
        return userService.getLoggedUser();
    }



}
