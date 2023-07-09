package com.aditya.controller;

import com.aditya.entity.User;
import com.aditya.service.AuthenticationService;
import com.aditya.views.LoginResponseView;
import com.aditya.views.RegistrationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationView registrationView){
        return authService.registerUser(registrationView.getUserName(),registrationView.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseView loginUser(@RequestBody RegistrationView loginView){
        return  authService.loginUser(loginView.getUserName(), loginView.getPassword());
    }
}
