package uth.edu.podbooking.domain.pod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.pod.entity.TypePod;

public interface TypePodRepository  extends JpaRepository<TypePod, Long> {
}
