package uth.edu.podbooking.domain.login.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.repository.AccountRepository;
import uth.edu.podbooking.domain.login.dto.LoginRequest;
import uth.edu.podbooking.domain.login.dto.LoginRespone;
import uth.edu.podbooking.domain.login.mapper.LoginMapper;

@Service
@Data
@AllArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public boolean login(LoginRequest loginRequest) {
        return true;
    }
}
