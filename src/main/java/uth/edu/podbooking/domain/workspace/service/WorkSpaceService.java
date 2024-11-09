package uth.edu.podbooking.domain.workspace.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;
import uth.edu.podbooking.domain.workspace.mapper.WorkSpaceMapper;
import uth.edu.podbooking.domain.workspace.repository.WorkSpaceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;
    private final WorkSpaceMapper workSpaceMapper;


    public List<WorkSpaceResponse> fetchAllWorkSpaces() {
        return this.workSpaceRepository
                .findAll()
                .stream()
                .map(workSpaceMapper::toWorkSpaceResponse)
                .toList();
    }
}
