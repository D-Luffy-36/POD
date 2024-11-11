package uth.edu.podbooking.domain.pod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.pod.entity.Amenity;

import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    List<Amenity> findByPrice(double price);
}
