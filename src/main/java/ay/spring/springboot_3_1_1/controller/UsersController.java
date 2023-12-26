package ay.spring.springboot_3_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ay.spring.springboot_3_1_1.model.User;
import ay.spring.springboot_3_1_1.service.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersALL(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String usersId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "user";
    }


    @GetMapping("/add")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";

    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute(userService.getUserId(id));
        return "edit";
    }


    @PatchMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }
}