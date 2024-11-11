package uth.edu.podbooking.domain.pod.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.pod.entity.TypePodName;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypePodResponse {
    private TypePodName name;
    private int capacity;
    private double pricePerHour;
    private String description;
}
