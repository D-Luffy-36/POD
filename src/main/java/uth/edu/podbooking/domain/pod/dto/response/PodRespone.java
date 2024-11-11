package uth.edu.podbooking.domain.pod.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.pod.entity.Amenity;
import uth.edu.podbooking.domain.pod.entity.PodRoomStatus;
import uth.edu.podbooking.domain.pod.entity.TypePod;

import java.util.Set;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PodRespone {
    private String name;
    private String img;
    private PodRoomStatus status;
    private TypePodResponse type;
    Set<AmenityResponse> amenities;
}
