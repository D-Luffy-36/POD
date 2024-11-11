package uth.edu.podbooking.domain.pod.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.dto.response.PodRespone;
import uth.edu.podbooking.domain.pod.service.PodService;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/pods")
public class PodController {
    private final PodService podService;

    @GetMapping()
    public Response<List<PodRespone>> listAmenities() {
        return Response.<List<PodRespone>>builder()
                .result(this.podService.fetchAllPods())
                .build();
    }
}
