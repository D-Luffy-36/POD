package uth.edu.podbooking.domain.account.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.dto.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.mapper.AccountMapper;
import uth.edu.podbooking.domain.account.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public List<AccountResponse> fetchAllAccounts() {
        List<Account> accounts =  this.accountRepository.findAll();
        System.out.println(accounts);
        return accountMapper.toAccountResponseList(accounts);
    }
    public Optional<AccountResponse> fetchAccountById(Long id) {
        Optional<Account> account = this.accountRepository.findById(id);
        Optional<AccountResponse> accountResponse;

        if (account.isPresent()) {
            accountResponse = account.map(accountMapper::toAccountResponse);
            return accountResponse;
        }
        return Optional.empty();
    }

}
