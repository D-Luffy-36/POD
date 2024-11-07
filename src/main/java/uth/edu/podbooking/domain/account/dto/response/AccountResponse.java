package uth.edu.podbooking.domain.account.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uth.edu.podbooking.domain.location.dto.LocationResponse;


import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
    private String fullName;
    private String email;
    private String phone;
    private String errorMessage; // bị thừa
    private Boolean isActive;
    private double points;
    private LocationResponse location;
    private Set<RoleResponse> roles;

    public AccountResponse(String errorMessage) {
        this.errorMessage = errorMessage; // Đặt thông báo lỗi
    }
}
