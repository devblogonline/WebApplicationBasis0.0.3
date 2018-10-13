package com.webApplicationBasis.User.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.webApplicationBasis.User.Model.*;
import com.webApplicationBasis.User.Services.*;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private UserDao  userDao;

    @RequestMapping(value = "newUser", method = RequestMethod.GET)
    public String newUserView(Model model) {

        model.addAttribute("user", new User() );
        return "newUser";
    }

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public String userOverview(Model model) {
        model.addAttribute("list", userRepository.findAll());
        return "userList";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model){

        userDao.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "messages", method = RequestMethod.GET)
    public ModelAndView userView(Authentication authentication){
    	//User authUser = (User) authentication.getPrincipal();
    	//System.out.println(authUser.getId());
    	Iterable<Message> messages = messageRepository.findAllMessagesToCurrentUser();
    	return new ModelAndView("messages", "messages", messages);
    }

}
