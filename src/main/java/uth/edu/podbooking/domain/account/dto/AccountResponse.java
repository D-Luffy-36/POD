package uth.edu.podbooking.domain.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
    private String fullName;
    private String email;
    private String phone;
    private String errorMessage;
    private Boolean isActive;

    public AccountResponse(String errorMessage) {
        this.errorMessage = errorMessage; // Đặt thông báo lỗi
    }
}
