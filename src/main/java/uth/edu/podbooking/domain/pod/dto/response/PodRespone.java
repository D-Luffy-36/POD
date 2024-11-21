package uth.edu.podbooking.domain.pod.dto.response;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.pod.entity.PodRoomStatus;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PodRespone {
    private String name;
    private String img;
    private PodRoomStatus status;
    private TypePodResponse type;
    @JsonIgnoreProperties({"price", "description"})
    Set<AmenityResponse> amenities;
    // Set<WorkSpaceResponse> workspaces;
}
