package uth.edu.podbooking.domain.pod.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.service.AmenityService;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/amenities")
public class AmenityController {
    private final AmenityService amenityService;

    @GetMapping()
    public Response<List<AmenityResponse>> listAmenities() {
          return Response.<List<AmenityResponse>>builder()
                .result(this.amenityService.fetchAllAmenities())
                .build();
    }

}
