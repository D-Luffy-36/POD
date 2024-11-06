package uth.edu.podbooking.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.account.entity.Role;


public interface RoleReppository  extends JpaRepository<Role, Long> {
}
