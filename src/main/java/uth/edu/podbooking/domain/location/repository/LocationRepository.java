package uth.edu.podbooking.domain.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.location.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
