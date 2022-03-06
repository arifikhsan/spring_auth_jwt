package com.example.spring_auth_jwt.service;

import com.example.spring_auth_jwt.domain.RoleDomain;
import com.example.spring_auth_jwt.domain.UserDomain;
import com.example.spring_auth_jwt.domain.UserRoleDomain;
import com.example.spring_auth_jwt.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRoleService {
    private final UserRoleRepository repository;

    public void create(UserDomain user, RoleDomain role) {
        repository.save(new UserRoleDomain(user, role));
    }
}
