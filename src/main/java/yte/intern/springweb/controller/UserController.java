package yte.intern.springweb.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springweb.model.User;

@RestController
public class UserController {
    @PostMapping("/user")
    public User validateUser(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
