package uth.edu.podbooking.domain.pod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.pod.entity.Pod;

public interface PodRepository extends JpaRepository<Pod, Long> {
}
