package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uth.edu.podbooking.common.NotFound;
import uth.edu.podbooking.domain.account.dto.AccountRequest;
import uth.edu.podbooking.domain.account.dto.AccountResponse;
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
    public ResponseEntity<List<AccountResponse>> getListAccounts(){
        List<AccountResponse> accountResponses = this.accountService.fetchAllAccounts();
        return ResponseEntity.ok(accountResponses);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<?> createAccount(@PathVariable Long id){
        Optional<AccountResponse> accountResponse = this.accountService.fetchAccountById(id);
        if (accountResponse.isPresent()){
            return ResponseEntity.ok(accountResponse.get());
        }
        String message = "Account with id " + id + " not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFound(message));
    }

    @PostMapping("/account/create")
    public AccountResponse create(@RequestBody AccountRequest request) {

        return new AccountResponse();
    }



}
