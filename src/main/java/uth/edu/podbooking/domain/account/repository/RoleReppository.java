package uth.edu.podbooking.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.account.entity.Role;

import java.util.Optional;

public interface RoleReppository  extends JpaRepository<Role, Long> {

    @Override
    Optional<Role> findById(Long id);
    Optional<Role> findByCode(String Code);

}
