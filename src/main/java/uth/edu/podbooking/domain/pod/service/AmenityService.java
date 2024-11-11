package uth.edu.podbooking.domain.pod.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.pod.dto.response.AmenityResponse;
import uth.edu.podbooking.domain.pod.mapper.AmenityMapper;
import uth.edu.podbooking.domain.pod.repository.AmenityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AmenityService {
    private final AmenityRepository amenityRepository;
    private final AmenityMapper amenityMapper;
    public List<AmenityResponse> fetchAllAmenities() {
        return this.amenityRepository
                .findAll()
                .stream()
                .map(amenityMapper::toAmenityResponse)
                .toList();
    }
}
