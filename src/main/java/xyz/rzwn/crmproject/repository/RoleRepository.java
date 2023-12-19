package xyz.rzwn.crmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rzwn.crmproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
