package uth.edu.podbooking.domain.login.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uth.edu.podbooking.domain.login.dto.LoginRequest;
import uth.edu.podbooking.domain.login.dto.LoginRespone;
import uth.edu.podbooking.domain.login.service.LoginService;

@RestController
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public LoginRespone login(@RequestBody LoginRequest loginRequest) {
        boolean auth = this.loginService.auth(loginRequest);
        if (auth) {
            return new LoginRespone(true);
        }
        return new LoginRespone(false);
    }
}
