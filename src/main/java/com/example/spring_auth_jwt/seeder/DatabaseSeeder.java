package com.example.spring_auth_jwt.seeder;

import com.example.spring_auth_jwt.domain.RoleDomain;
import com.example.spring_auth_jwt.domain.UserDomain;
import com.example.spring_auth_jwt.service.RoleService;
import com.example.spring_auth_jwt.service.UserRoleService;
import com.example.spring_auth_jwt.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DatabaseSeeder {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, RoleService roleService, UserRoleService userRoleService) {
        return args -> {
            var role = new RoleDomain("admin");
            var user = new UserDomain("admin", "admin@example.com", "123456");

            var savedRole = roleService.create(role);
            var savedUser = userService.create(user);
            userRoleService.create(savedUser, savedRole);
        };
    }
}
