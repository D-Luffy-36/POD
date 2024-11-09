package uth.edu.podbooking.domain.pod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.pod.entity.Amenity;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
