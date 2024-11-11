package uth.edu.podbooking.domain.pod.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmenityResponse {
    private String name;
    private String description;
    private double price;
    private boolean available;
}
