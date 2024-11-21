package uth.edu.podbooking.domain.account.service;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uth.edu.podbooking.domain.account.dto.response.RoleResponse;
import uth.edu.podbooking.domain.account.mapper.RoleMapper;
import uth.edu.podbooking.domain.account.repository.RoleReppository;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleMapper roleMapper;
    private final RoleReppository roleReppository;

    public List<RoleResponse> fetchAllRoles(){
        return roleReppository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

}
