package xyz.rzwn.crmproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.rzwn.crmproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
