package uth.edu.podbooking.domain.location.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationResponse {
    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
}
