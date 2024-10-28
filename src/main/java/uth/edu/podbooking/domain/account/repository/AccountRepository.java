package uth.edu.podbooking.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.account.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    List<Account> findAll();
}
