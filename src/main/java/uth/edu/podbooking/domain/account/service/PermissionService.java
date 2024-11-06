package uth.edu.podbooking.domain.account.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.dto.request.PermissionRequest;
import uth.edu.podbooking.domain.account.dto.response.PermissionResponse;
import uth.edu.podbooking.domain.account.entity.Permission;
import uth.edu.podbooking.domain.account.mapper.PermissionMapper;
import uth.edu.podbooking.domain.account.repository.AccountRepository;
import uth.edu.podbooking.domain.account.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public List<PermissionResponse> fetAllPermissions() {
            return this
                    .permissionRepository
                    .findAll()
                    .stream()
                    .map(permissionMapper::toPermissionResponse)
                    .toList();
    }

    public Optional<PermissionResponse> creatPermission(PermissionRequest permissionRequest) {
        // check tồn tại hay chưa
        boolean flag = this.permissionRepository.existsByCode(permissionRequest.getCode());

        if (flag) {
            return Optional.empty();
        }
        Permission permission = permissionRepository.save(this.permissionMapper.toPermission(permissionRequest));

        return Optional.of(this.permissionMapper.toPermissionResponse(permission));
    }
}
