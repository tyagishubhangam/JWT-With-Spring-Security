package com.noobie.Security_Demo.controllers;

import com.noobie.Security_Demo.model.MyUser;
import com.noobie.Security_Demo.service.MyUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {
    MyUserService myUserService;
    public MyController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/")
    public String home(){
        return "Hello World Welcome to Security Demo";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MyUser user){
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        myUserService.signup(user);
        return "Registered success";
    }
    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
         return myUserService.verify(user);

    }
}
