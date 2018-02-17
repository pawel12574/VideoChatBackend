package corpchat.controller;

import corpchat.dao.ChatRepository;
import corpchat.dao.MessageRepository;
import corpchat.dao.UserRepository;
import corpchat.model.Chat;
import corpchat.model.Message;
import corpchat.model.User;
import corpchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MessageController {

    @Autowired
    ChatRepository chatRepository;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/chat/{friendId}", method = GET) //chat by friend id
    public Chat getMessages(@PathVariable("friendId") Long id){

        return chatRepository.getChat(id, userService.getLoggedUser().getId());
    }




}
