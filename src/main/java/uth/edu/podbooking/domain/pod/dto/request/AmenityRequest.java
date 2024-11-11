package uth.edu.podbooking.domain.pod.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmenityRequest {
    private String name;
    private String description;
    private double price;
    private boolean available = true;
}
