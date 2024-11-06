package uth.edu.podbooking.domain.account.mapper;

import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.account.dto.request.PermissionRequest;
import uth.edu.podbooking.domain.account.dto.response.PermissionResponse;
import uth.edu.podbooking.domain.account.entity.Permission;


@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}

