package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.request.PermissionRequest;
import uth.edu.podbooking.domain.account.dto.response.PermissionResponse;
import uth.edu.podbooking.domain.account.service.PermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/permissions")
public class PermissionController {
    private PermissionService permissionService;

    @GetMapping()
    public Response<List<PermissionResponse>> ListPermissions() {
        return Response
                .<List<PermissionResponse>>builder()
                .result(this.permissionService.fetAllPermissions())
                .build();
    }

    @PostMapping()
    public Response<PermissionResponse> create(@RequestBody PermissionRequest permissionRequest) {
        Optional<PermissionResponse> permissionResponse = this.permissionService.creatPermission(permissionRequest);

        return permissionResponse.isEmpty()
                ?
                Response
                .<PermissionResponse>builder()
                .message(permissionRequest.getCode() + " has existed!")
                .build()
                :
                Response
                .<PermissionResponse>builder()
                .result(permissionResponse.get())
                .build();

    }
}

