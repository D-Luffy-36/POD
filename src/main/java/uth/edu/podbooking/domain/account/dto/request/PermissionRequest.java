package uth.edu.podbooking.domain.account.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PermissionRequest {
    String code;
    String description;
}
