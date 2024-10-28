package uth.edu.podbooking.domain.account.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {
    private String email;
    private String password;
    private String confirmPassword;
}
