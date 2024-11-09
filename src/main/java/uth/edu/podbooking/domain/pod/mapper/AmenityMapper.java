package uth.edu.podbooking.domain.pod.mapper;


import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.pod.dto.AmenityRequest;
import uth.edu.podbooking.domain.pod.dto.AmenityResponse;
import uth.edu.podbooking.domain.pod.entity.Amenity;

@Mapper(componentModel = "spring")
public interface AmenityMapper {
    Amenity toAmenity(AmenityRequest amenityRequest);
    AmenityResponse toAmenityResponse(Amenity amenity);
}
