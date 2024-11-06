package uth.edu.podbooking.domain.account.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.dto.response.RoleResponse;
import uth.edu.podbooking.domain.account.enums.Role;
import uth.edu.podbooking.domain.account.mapper.RoleMapper;
import uth.edu.podbooking.domain.account.repository.RoleReppository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleMapper roleMapper;
    private final RoleReppository roleReppository;

    public List<RoleResponse> fetchAllRoles(){
        return roleReppository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

}
