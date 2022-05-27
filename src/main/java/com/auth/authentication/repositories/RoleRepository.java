package com.auth.authentication.repositories;

import com.auth.authentication.auth.ERole;
import com.auth.authentication.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    @Query(value = "select count(*) from role",
            nativeQuery = true)
    int isRoleEmpty();

    @Query(value = "Insert into role (name) name values(:roleName) ",
            nativeQuery = true)
    void insertRoles(@Param("roleName") ERole role);

}
