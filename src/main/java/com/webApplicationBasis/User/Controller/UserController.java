package com.webApplicationBasis.User.Controller;


import java.util.List;

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
    private UserDao  userDao;
    
    @Autowired
    private NoteDao noteDao;

    @RequestMapping(value = "newUser", method = RequestMethod.GET)
    public String newUserView(Model model) {

        model.addAttribute("user", new User() );
        return "newUser";
    }

    @RequestMapping(value = "admin/userList", method = RequestMethod.GET)
    public String userOverview(Model model) {
        model.addAttribute("list", userRepository.findAll());
        return "admin/userList";
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

    @RequestMapping(value = "user/privateSpace", method = RequestMethod.GET)
    public ModelAndView userView(Model model){
    	List<Note> notes = userRepository.findAllNotesFromCurrentUser();
    	model.addAttribute("newNote", new Note() );
    	return new ModelAndView("user/privateSpace", "notes", notes);
    }
    
    @RequestMapping(value = "addNote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute Note newNote, Model model, Authentication authentication){
    	User currentUser = userRepository.findByUsername(authentication.getName());
    	newNote.setOwner(currentUser);
    	noteDao.addNote(newNote);
    	return "redirect:/user/privateSpace";
    }

}
