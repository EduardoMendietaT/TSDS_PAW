package com.pruebaauth.security.repository;

import java.util.Optional;

import com.pruebaauth.security.models.ERole;
import com.pruebaauth.security.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    Optional<Role> findByName(ERole name);
}
