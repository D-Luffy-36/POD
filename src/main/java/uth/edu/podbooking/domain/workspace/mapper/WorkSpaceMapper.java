package uth.edu.podbooking.domain.workspace.mapper;


import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceRequest;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;
import uth.edu.podbooking.domain.workspace.entity.WorkSpace;

@Mapper(componentModel = "spring")
public interface WorkSpaceMapper {
    WorkSpace toWorkSpace(WorkSpaceRequest workSpaceRequest);

    WorkSpaceResponse toWorkSpaceResponse (WorkSpace workSpace);
}
