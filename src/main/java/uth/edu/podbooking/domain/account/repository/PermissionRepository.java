package uth.edu.podbooking.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.account.entity.Permission;

import java.util.Optional;

public interface PermissionRepository  extends JpaRepository<Permission, Long>  {

    @Override
    Optional<Permission> findById(Long aLong);
    Optional<Permission> findByCode(String Code);

}
