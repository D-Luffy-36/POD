package uth.edu.podbooking.domain.pod.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.dto.response.TypePodResponse;
import uth.edu.podbooking.domain.pod.mapper.TypePodMapper;
import uth.edu.podbooking.domain.pod.repository.TypePodRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TypePodService {
    private final TypePodMapper typePodMapper;
    private final TypePodRepository typePodRepository;


    public List<TypePodResponse> fetchAllTypePodResponses() {
        return this.typePodRepository
                .findAll()
                .stream()
                .map(typePodMapper::toTypePodResponse)
                .toList();
    }
}
