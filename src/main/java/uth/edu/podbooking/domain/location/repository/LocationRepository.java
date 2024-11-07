package uth.edu.podbooking.domain.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uth.edu.podbooking.domain.location.entity.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query()
    List<Location> findLocationsByName(String name);
}
