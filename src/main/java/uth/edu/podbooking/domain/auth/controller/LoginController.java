package uth.edu.podbooking.domain.auth.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.auth.dto.request.LoginRequest;
import uth.edu.podbooking.domain.auth.dto.respone.LoginRespone;
import uth.edu.podbooking.domain.auth.service.LoginService;

@RestController
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public Response<LoginRespone> login(@RequestBody LoginRequest loginRequest) {
        boolean auth = this.loginService.auth(loginRequest);
        LoginRespone loginRespone = new LoginRespone(auth);

        loginRespone.setAuthenticated(auth);

        Response<LoginRespone> response = new Response<>();
        response.setResult(loginRespone);
        return response;
    }
}
