package com.goruslan.socialgeeking.controller;

import com.goruslan.socialgeeking.service.EquiposService;
import com.goruslan.socialgeeking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("techs/userslist")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/techs/userslist";
    }

}
