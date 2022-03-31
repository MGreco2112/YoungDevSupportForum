package com.auth.authentication.repositories;

import com.auth.authentication.auth.ERole;
import com.auth.authentication.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
