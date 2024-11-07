package uth.edu.podbooking.domain.location.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationRequest {
    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
}
