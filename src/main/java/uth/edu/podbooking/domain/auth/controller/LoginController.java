package uth.edu.podbooking.domain.auth.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.auth.dto.request.AuthTokenRequest;
import uth.edu.podbooking.domain.auth.dto.request.LoginRequest;
import uth.edu.podbooking.domain.auth.dto.respone.AuthTokenResponse;
import uth.edu.podbooking.domain.auth.dto.respone.LoginResponse;
import uth.edu.podbooking.domain.auth.service.LoginService;

@RestController
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public Response<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse auth = this.loginService.auth(loginRequest);
        return Response.<LoginResponse>builder()
                .result(auth)
                .build();
    }

    @PostMapping("/token")
    public Response<AuthTokenResponse> authToken(@RequestBody AuthTokenRequest authTokenRequest) {
        AuthTokenResponse authTokenResponse = this.loginService.checkToken(authTokenRequest);

        return Response.<AuthTokenResponse>builder() // Sửa thành AuthTokenResponse
                .result(authTokenResponse)
                .build();
    }




}
