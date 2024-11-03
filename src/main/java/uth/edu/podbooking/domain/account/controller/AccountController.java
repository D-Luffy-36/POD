package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.request.AccountRequest;
import uth.edu.podbooking.domain.account.dto.respone.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.service.AccountService;
import java.util.List;
import java.util.Optional;


@RestController
@Data
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts")
    public Response<List<AccountResponse>> listAccounts(){
        List<AccountResponse> accountResponses = this.accountService.fetchAllAccounts();
        Response<List<AccountResponse>> response = new Response<>();
        response.setResult(accountResponses);
        return response;
    }

    @GetMapping("/accounts/{id}")
    public Response<AccountResponse> detail(@PathVariable Long id){
        Optional<AccountResponse> accountResponse = this.accountService.fetchAccountById(id);
        Response<AccountResponse> response = new Response<>();

        if (accountResponse.isEmpty()){
            String message = "Account with id " + id + " not found";
            response.setMessage(message);
        }else {
            response.setResult(accountResponse.get());
        }
        return response;
    }

    @PostMapping("/accounts")
    public Response<ResponseEntity<AccountResponse>> create(@RequestBody AccountRequest request) {
        Optional<AccountResponse> accountResponse = this.accountService.createAccount(request);
        Response<ResponseEntity<AccountResponse>> response = new Response<>();
        if (accountResponse.isEmpty()){
            String message = "Account with email " + request.getEmail() + " was existed";
            response.setMessage(message);
            return response;
        }
        return response;
    }

    @PatchMapping("/accounts/{id}")
    public Response<AccountResponse> update(@PathVariable Long id, @RequestBody Account account) {
        Optional<AccountResponse> accountResponse = this.accountService.updateAccount(id , account);
        Response<AccountResponse> response = new Response<>();
        if (accountResponse.isEmpty()){
            String message = "Account with id " + id + " not found";
            response.setMessage(message);
            return response;
        }
        response.setResult(accountResponse.get());
        return response;
    }

    @DeleteMapping("/accounts/{id}")
    public Response<AccountResponse> delete(@PathVariable Long id) {
        Optional<AccountResponse> accountResponse = this.accountService.softDeleteAccount(id);
        Response<AccountResponse> response = new Response<>();
        if (accountResponse.isEmpty()){
            String message = "Account with id " + id + " not found";
            response.setMessage(message);
            return response;
        }
        response.setResult(accountResponse.get());
        return response;
    }
}
