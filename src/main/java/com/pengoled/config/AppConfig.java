package com.pengoled.config;

import com.pengoled.domain.Role;
import com.pengoled.domain.User;
import com.pengoled.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class AppConfig {

    @Bean
    public CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Travolta", "john123", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Kerry Tippin", "kerry123", "1010", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim12345", "jim10", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "willy10", "will1010", new ArrayList<>()));

            userService.addRoleToUser("john123", "ROLE_USER");
            userService.addRoleToUser("john123", "ROLE_MANAGER");
            userService.addRoleToUser("kerry123", "ROLE_ADMIN");
            userService.addRoleToUser("jim12345", "ROLE_ADMIN");
            userService.addRoleToUser("jim12345", "ROLE_MANAGER");
            userService.addRoleToUser("jim12345", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("willy10", "ROLE_USER");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
