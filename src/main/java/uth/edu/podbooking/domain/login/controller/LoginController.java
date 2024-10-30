package uth.edu.podbooking.domain.login.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.login.dto.LoginRequest;
import uth.edu.podbooking.domain.login.dto.LoginRespone;
import uth.edu.podbooking.domain.login.service.LoginService;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginRespone> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(new LoginRespone());
    }

}
