package edu.kata.task311.controller.impl;

import edu.kata.task311.controller.IndexController;
import edu.kata.task311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexControllerImpl implements IndexController {

    private final UserService userService;

    public IndexControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.findAll());
        return "index";
    }
}
