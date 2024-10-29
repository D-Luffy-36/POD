package uth.edu.podbooking.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String fullName;
    private String email;
    private String phone;
    private String errorMessage;
    private boolean isActive;

    public AccountResponse(String errorMessage) {
        this.errorMessage = errorMessage; // Đặt thông báo lỗi
    }
}
