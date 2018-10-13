package com.webApplicationBasis.Home.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webApplicationBasis.User.Model.User;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {

        model.addAttribute("user", new User() );
        return "home";
    }
}

