package uth.edu.podbooking.domain.account.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.response.RoleResponse;
import uth.edu.podbooking.domain.account.service.RoleService;

import java.util.List;

@Builder
@RestController
@AllArgsConstructor
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final RoleService roleService;

    @GetMapping("/roles")
    public Response<List<RoleResponse>> ListRoles() {
            return Response.<List<RoleResponse>>builder()
                    .result(this.roleService.fetchAllRoles())
                    .build();
    }

}
