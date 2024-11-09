package uth.edu.podbooking.domain.workspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace, Long> {

}
