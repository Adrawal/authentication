package com.aditya.service;

import com.aditya.entity.Roles;
import com.aditya.entity.User;
import com.aditya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
@Autowired
private PasswordEncoder encoder;
@Autowired
private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("in the user details service");

        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user info not found"));
       /** if(!username.equals("aditya"))throw new UsernameNotFoundException("not Aditya");
        Set<Roles> roles = new HashSet<>();
        roles.add(new Roles(1L, "USER"));
        return new User(1L,"Aditya",encoder.encode("password"), roles);
        **/
    }
}
