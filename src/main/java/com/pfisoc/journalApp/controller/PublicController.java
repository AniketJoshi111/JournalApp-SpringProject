package com.pfisoc.journalApp.controller;

import com.pfisoc.journalApp.entity.User;
import com.pfisoc.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String  health()
    {
        return "i am fine";
    }


    @PostMapping("/create-user")
    public void createUser(@RequestBody User user)
    {
        userService.saveEntry(user);
    }
}
