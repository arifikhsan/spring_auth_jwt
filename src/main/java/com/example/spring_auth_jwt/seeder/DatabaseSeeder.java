package com.example.spring_auth_jwt.seeder;

import com.example.spring_auth_jwt.domain.RoleDomain;
import com.example.spring_auth_jwt.domain.UserDomain;
import com.example.spring_auth_jwt.domain.UserRoleDomain;
import com.example.spring_auth_jwt.repository.RoleRepository;
import com.example.spring_auth_jwt.repository.UserRepository;
import com.example.spring_auth_jwt.repository.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class DatabaseSeeder {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            RoleRepository roleRepository,
            UserRoleRepository userRoleRepository) {

        return args -> {
            var role = new RoleDomain("admin");
            var user = new UserDomain("user@example", "123456");

            var savedRole = roleRepository.save(role);
            var savedUser = userRepository.save(user);
            var userRole = new UserRoleDomain(savedUser, savedRole);
            userRoleRepository.save(userRole);
        };
    }
}
