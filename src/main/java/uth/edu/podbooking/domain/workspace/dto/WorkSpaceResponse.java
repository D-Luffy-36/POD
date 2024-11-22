package uth.edu.podbooking.domain.workspace.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.location.entity.Location;
import uth.edu.podbooking.domain.pod.dto.response.PodRespone;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkSpaceResponse {
    private Long id;
    private String name;
}
