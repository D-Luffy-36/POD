package uth.edu.podbooking.domain.pod.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.dto.response.TypePodResponse;
import uth.edu.podbooking.domain.pod.service.TypePodService;

import java.util.List;

@RestController
@RequestMapping("/typepods")
@AllArgsConstructor
public class TypePodController {
    private final TypePodService typePodService;
    @GetMapping
    public Response<List<TypePodResponse>> listAmenities() {
        return Response.<List<TypePodResponse>>builder()
                .result(this.typePodService.fetchAllTypePodResponses())
                .build();
    }
}
