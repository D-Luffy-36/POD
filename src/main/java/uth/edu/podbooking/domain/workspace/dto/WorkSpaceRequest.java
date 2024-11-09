package uth.edu.podbooking.domain.workspace.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import uth.edu.podbooking.domain.location.dto.LocationRequest;

import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkSpaceRequest {
    private String name;
    private Set<LocationRequest> locations;
}
