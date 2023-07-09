package com.aditya;

import com.aditya.entity.Roles;
import com.aditya.repository.RoleRepository;
import com.aditya.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticationbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationbackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder){
		return args -> {
			if(roleRepo.findByAuthority("ADMIN").isPresent()) {
				return;
			}else {
				Roles adminRole = roleRepo.save(new Roles("ADMIN"));
				roleRepo.save(new Roles("USER"));
				Set<Roles> roles = new HashSet<>();
				roles.add(adminRole);
			}
		};

	}
}
