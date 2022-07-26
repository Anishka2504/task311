package edu.kata.task311.controller.impl;

import edu.kata.task311.controller.UserController;
import edu.kata.task311.entity.User;
import edu.kata.task311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String pageCreate(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user_manage";
    }

    @Override
    public String create(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    @Override
    public String pageUpdate(ModelMap modelMap, Long id) {
        modelMap.addAttribute("user", userService.findById(id));
        return "user_manage";
    }

    @Override
    public String update(User user) {
        userService.save(user);
        return "redirect:/index";
    }

    @Override
    public String remove(Long id) {
        userService.delete(id);
        return "redirect:/index";
    }
}
