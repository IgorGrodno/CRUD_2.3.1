package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.AppConfig;
import web.models.User;
import web.services.UserService;
import web.services.UserServiceImp;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/1")
    public String getAllUsers(Model model) {
        userService.add(new User("name","lastName","eMail"));
        List<User> users = userService.listUsers();
        users.add(new User("11","22","33"));

        model.addAttribute("users", users);
        return "111";
    }
}

