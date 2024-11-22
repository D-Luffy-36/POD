package uth.edu.podbooking.domain.account.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.request.AccountRequest;
import uth.edu.podbooking.domain.account.dto.response.AccountResponse;
import uth.edu.podbooking.domain.account.service.AccountService;

@RestController
@Data
@AllArgsConstructor

@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    // @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping()
    public Response<List<AccountResponse>> listAccounts(){
        return Response.<List<AccountResponse>>builder()
                .result(this.accountService.fetchAllAccounts())
                .build();
    }

    @GetMapping("/{id}")
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

    @PostMapping()
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

    @PatchMapping("/{id}")
    public Response<AccountResponse> update(@PathVariable Long id, @RequestBody AccountRequest accountRequest) {
        Optional<AccountResponse> accountResponse = this.accountService.updateAccount(id, accountRequest);

        return  accountResponse.isEmpty()
                ?
                Response.<AccountResponse>builder()
                    .message("Account with id " + id + " not found")
                    .build()
                :
                Response.<AccountResponse>builder()
                        .result(accountResponse.get())
                        .build();
    }

    @DeleteMapping("/{id}")
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
