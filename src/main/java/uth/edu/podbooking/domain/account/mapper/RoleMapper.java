package uth.edu.podbooking.domain.account.mapper;


import org.mapstruct.Mapper;
import uth.edu.podbooking.domain.account.dto.response.RoleResponse;
import uth.edu.podbooking.domain.account.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);
}
