package sked.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sked.ecommerce.entity.user.ERole;
import sked.ecommerce.entity.user.Role;


import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}  
