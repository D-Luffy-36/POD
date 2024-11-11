package uth.edu.podbooking.domain.pod.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.dto.response.PodRespone;
import uth.edu.podbooking.domain.pod.mapper.PodMapper;
import uth.edu.podbooking.domain.pod.repository.PodRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PodService {
    private PodRepository podRepository;
    private AmenityService amenityService;
    private PodMapper podMapper;

    public List<PodRespone> fetchAllPods() {
        return this.podRepository
                .findAll()
                .stream()
                .map(podMapper::toPodRespone)
                .toList();
    }

    public void addAllAmenitiesToPod(Long podId) {

    }


}
