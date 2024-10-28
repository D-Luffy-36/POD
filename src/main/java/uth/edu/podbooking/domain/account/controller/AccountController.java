package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uth.edu.podbooking.domain.account.dto.AccountRequest;
import uth.edu.podbooking.domain.account.dto.AccountResponse;
import uth.edu.podbooking.domain.account.service.AccountService;

import java.util.List;


@Controller
@Data
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

//    @GetMapping("/admin/accounts")
//    public ResponseEntity<ResponseObject> getAllAccounts() {
//        List<Account> accounts = null;
//        try {
//            accounts = this.accountService.fetchAllAccounts();
//            System.out.println(accounts);
//
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("200", "", accounts));
//    }
//
//    @PostMapping("/admin/create/account")
//    public ResponseEntity<ResponseObject> createAccount(@RequestBody AccountDTO accountDTO) {
//        logger.info(accountDTO.toString());
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("200", "", ""));
//    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountResponse>> getListAccounts(){
        List<AccountResponse> accountResponses = this.accountService.fetchAllAccounts();
        return ResponseEntity.ok(accountResponses);
    }


    @PostMapping("/account/create")
    public AccountResponse create(@RequestBody AccountRequest request) {

        return new AccountResponse();
    }

}
