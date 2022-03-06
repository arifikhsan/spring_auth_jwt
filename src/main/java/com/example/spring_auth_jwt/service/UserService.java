package com.example.spring_auth_jwt.service;

import com.example.spring_auth_jwt.domain.RoleDomain;
import com.example.spring_auth_jwt.domain.UserDomain;
import com.example.spring_auth_jwt.domain.UserRoleDomain;
import com.example.spring_auth_jwt.repository.UserRepository;
import com.example.spring_auth_jwt.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    public final UserRepository repository;
    public final UserRoleRepository userRoleRepository;
    public final PasswordEncoder passwordEncoder;

    public List<UserDomain> all() {
        return repository.findAll();
    }

    public UserDomain one(String username) {
        return repository.findByUsername(username);
    }

    public UserDomain create(UserDomain user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserDomain addRole(UserDomain user, RoleDomain role) {
        var userRole = userRoleRepository.save(new UserRoleDomain(user, role));
        return userRole.getUser();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);
        var authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList();
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
