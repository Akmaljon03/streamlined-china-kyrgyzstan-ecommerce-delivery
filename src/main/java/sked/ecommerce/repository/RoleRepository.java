package sked.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import sked.ecommerce.entity.user.ERole;
import sked.ecommerce.entity.user.Role;

@Repository
@EnableJpaRepositories(basePackages = "sked.ecommerce.repository")
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
