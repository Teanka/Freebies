package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.Role;
import pl.coderslab.entity.User;
import pl.coderslab.service.RoleService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/register";
        }

        User userCheckEmail = userService.findByEmail(user.getEmail());

        if (userCheckEmail == null) {
            Role role = roleService.findByName("USER");
            Set<Role> allRoles = new HashSet<>();
            allRoles.add(role);
            user.setRoles(allRoles);
            userService.saveUser(user);
            return "redirect:/login";
        }
        return "user/register";

    }
}