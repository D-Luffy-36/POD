package uth.edu.podbooking.domain.workspace.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.location.entity.Location;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkSpaceResponse {
    private String name;
    private Set<LocationResponse> locations;
}
