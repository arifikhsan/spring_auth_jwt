package com.example.spring_auth_jwt.service;

import com.example.spring_auth_jwt.domain.RoleDomain;
import com.example.spring_auth_jwt.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private final RoleRepository repository;

    public RoleDomain create(RoleDomain role) {
        return repository.save(role);
    }
}
