package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.request.AccountRequest;
import uth.edu.podbooking.domain.account.dto.response.AccountResponse;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.service.AccountService;
import uth.edu.podbooking.domain.account.service.RoleService;

import java.util.List;
import java.util.Optional;


@RestController
@Data
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

//    return Response
//            .<List<PermissionResponse>>builder()
//                .result(this.permissionService.fetAllPermissions())
//            .build();

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
