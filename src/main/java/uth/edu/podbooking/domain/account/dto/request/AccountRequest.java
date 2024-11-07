package uth.edu.podbooking.domain.account.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.location.dto.LocationRequest;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String confirmPassword;
    private Boolean isActive;
    private LocationRequest location;
}
