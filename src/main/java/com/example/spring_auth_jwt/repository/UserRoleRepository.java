package com.example.spring_auth_jwt.repository;

import com.example.spring_auth_jwt.domain.UserRoleDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleDomain, Long> { }
