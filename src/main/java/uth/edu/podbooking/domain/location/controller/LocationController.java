package uth.edu.podbooking.domain.location.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.location.service.LocationService;

import java.util.List;


@Data
@AllArgsConstructor
@RestController()
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping()
    public Response<List<LocationResponse>> listLocations() {
        return Response.<List<LocationResponse>>builder()
                .result(this.locationService.fetchAllLocations())
                .build();
    }

    @GetMapping("/workspaces")
    public Response<List<LocationResponse>> listWorkspaceLocations() {
        return Response.<List<LocationResponse>>builder()
                .result(this.locationService.fetchAllWorkspaceLocations())
                .build();
    }






}
