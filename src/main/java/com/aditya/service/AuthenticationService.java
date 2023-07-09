package com.aditya.service;

import com.aditya.entity.Roles;
import com.aditya.entity.User;
import com.aditya.repository.RoleRepository;
import com.aditya.repository.UserRepository;
import com.aditya.views.LoginResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public User registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        String updateEncodedPassword ="{bcrypt}".concat(encodedPassword);
        Roles userRole = roleRepository.findByAuthority("USER").get();
        Set<Roles> roles = new HashSet<>();
        roles.add(userRole);
       return  userRepository.save(new User(0L,username,updateEncodedPassword,roles));
    }

    public LoginResponseView loginUser(String userName, String password){
        try{
           UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(userName,password);
            Authentication authentication =  authenticationManager.authenticate(authToken);
            String token = tokenService.generateJWT(authentication);
            return  new LoginResponseView(userRepository.findByUsername(userName).get(),token);

        }catch (Exception exp ){
            exp.printStackTrace();
            return  new LoginResponseView(null, "");
        }

    }
}
