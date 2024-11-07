package uth.edu.podbooking.domain.location.mapper;


import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.location.dto.LocationRequest;
import uth.edu.podbooking.domain.location.dto.LocationResponse;
import uth.edu.podbooking.domain.location.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location toLocation(LocationRequest locationRequest);

    LocationResponse toLocationResponse(Location location);
}
