package uth.edu.podbooking.domain.location.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.location.mapper.LocationMapper;
import uth.edu.podbooking.domain.location.repository.LocationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationResponse> fetchAllLocations() {
        return this.locationRepository
                .findAll().stream()
                .map(locationMapper::toLocationResponse)
                .toList();
    }

    // lay ra duoc danh sach vị trí có name:  workspace
    public List<LocationResponse> fetchAllWorkspaceLocations() {
        return this.locationRepository
                .findLocationsByName("WorkSpace Flow").stream()
                .map(locationMapper::toLocationResponse)
                .toList();
    }

}
