package uth.edu.podbooking.domain.account.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {
    private String email;
    private String password;
    private String confirmPassword;
    private Boolean isVip;

}
