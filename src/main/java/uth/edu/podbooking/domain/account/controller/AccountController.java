package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uth.edu.podbooking.domain.account.dto.AccountRequest;
import uth.edu.podbooking.domain.account.dto.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.service.AccountService;
import java.util.List;
import java.util.Optional;


@Controller
@Data
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> listAccounts(){
        List<AccountResponse> accountResponses = this.accountService.fetchAllAccounts();
        return ResponseEntity.ok(accountResponses);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> create(@PathVariable Long id){
        Optional<AccountResponse> accountResponse = this.accountService.fetchAccountById(id);
        if (accountResponse.isEmpty()){
            String message = "Account with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AccountResponse(message));
        }
        return ResponseEntity.ok(accountResponse.get());
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest request) {
        System.out.println(request);
        Optional<AccountResponse> accountResponse = this.accountService.createAccount(request);

        if (accountResponse.isEmpty()){
            String message = "Account with email " + request.getEmail() + " was existed";
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new AccountResponse(message));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse.get());
    }

    @PatchMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> update(@PathVariable Long id, @RequestBody Account account) {
        Optional<AccountResponse> accountResponse = this.accountService.updateAccount(id , account);
        logger.info(accountResponse.toString());
        return ResponseEntity.ok(accountResponse.get());
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<AccountResponse> delete(@PathVariable Long id) {
        Optional<AccountResponse> accountResponse = this.accountService.softDeleteAccount(id);
        if (accountResponse.isEmpty()){
            String message = "Account with id " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AccountResponse(message));
        }
        return ResponseEntity.ok(accountResponse.get());
    }




}
