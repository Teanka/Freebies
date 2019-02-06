package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String login() {

        return "user/logged";
    }
}
