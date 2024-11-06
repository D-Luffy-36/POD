package uth.edu.podbooking.domain.account.service;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.dto.request.AccountRequest;
import uth.edu.podbooking.domain.account.dto.response.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.mapper.AccountMapper;
import uth.edu.podbooking.domain.account.repository.AccountRepository;
import uth.edu.podbooking.domain.account.repository.RoleReppository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;


    public List<AccountResponse> fetchAllAccounts() {
        List<Account> accounts =  this.accountRepository.findAll();
        return this.accountRepository
                .findAll()
                .stream()
                .map(accountMapper::toAccountResponse)
                .toList();
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

    public Optional<AccountResponse> fetchAccountByEmail(String email) {
        Optional<Account> account = this.accountRepository.findByEmail(email);
        Optional<AccountResponse> accountResponse;
        if (account.isPresent()) {
            accountResponse = account.map(accountMapper::toAccountResponse);
            return accountResponse;
        }
        return Optional.empty();
    }

    public Optional<AccountResponse> createAccount(AccountRequest accountRequest) {
        // email tồn tại
        if(fetchAccountByEmail(accountRequest.getEmail()).isPresent()){
            return Optional.empty();
        }

        Account account;
        AccountResponse accountResponse;

        if(accountRequest.getPassword().equals(accountRequest.getConfirmPassword())){
            account = accountMapper.toAccount(accountRequest);
            Date date = new Date();
            account.setCreated(date);
            account.setUpdated(date);
            account.setIsActive(true);
            String encodedPassword = passwordEncoder.encode(accountRequest.getPassword());
            account.setPassword(encodedPassword);
            accountResponse = accountMapper.toAccountResponse(accountRepository.save(account));
            return Optional.of(accountResponse);
        }
        return Optional.empty();
    }

    public Optional<AccountResponse> updateAccount(Long id, Account account) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            return Optional.empty();
        }
        accountOptional.get().setFirstName(account.getFirstName());
        accountOptional.get().setLastName(account.getLastName());
        accountOptional.get().setFullName(account.getFirstName() + " " + account.getLastName());
        accountOptional.get().setPhone(account.getPhone());
        accountOptional.get().setEmail(account.getEmail());
        accountOptional.get().setIsActive(account.getIsActive());
        accountOptional.get().setUpdated(new Date());
        return Optional.of(accountMapper.toAccountResponse(accountRepository.save(accountOptional.get())));
    }

    public Optional<AccountResponse> softDeleteAccount(Long id) {
        Optional<Account> accountOptional = this.accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            return Optional.empty();
        }
        accountOptional.get().setIsActive(false);
        accountOptional.get().setUpdated(new Date());
        return Optional.of(accountMapper.toAccountResponse(accountRepository.save(accountOptional.get())));
    }
}
