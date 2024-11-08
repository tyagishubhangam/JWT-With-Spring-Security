package com.noobie.Security_Demo.service;

import com.noobie.Security_Demo.model.MyUser;
import com.noobie.Security_Demo.repositories.MyUserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
    public MyUserRepo myUserRepo;
    AuthenticationManager authenticationManager;
    JWTService jwtService;
    public MyUserService(MyUserRepo myUserRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.myUserRepo = myUserRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public void signup(MyUser myUser) {

        myUserRepo.save(myUser);
    }

    public String verify(MyUser user) {
        Authentication auth = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                user.getPassword()));
        if(auth.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }
        return "Incorrect username or password";
    }
}
