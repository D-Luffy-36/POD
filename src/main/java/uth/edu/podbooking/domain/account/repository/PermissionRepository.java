package uth.edu.podbooking.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.account.entity.Permission;

import java.util.Optional;

public interface PermissionRepository  extends JpaRepository<Permission, Long>  {
    Optional<Permission> findByCode(String Code);
    boolean existsByCode(String code);
}
