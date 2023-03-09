package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getAllUser(Model users) {
        users.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping("/saveget")
    public String saveUserGet(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/savepost")
    public String saveUserPost(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/usereditorget/{id}")
    public String userEditorGet(Model user, @PathVariable("id") Long id) {
        user.addAttribute("user", userService.getUser(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String userEditorPatch(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.edit(user, id);
        return "redirect:/";
    }
}