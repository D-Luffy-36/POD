package uth.edu.podbooking.domain.workspace.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.account.dto.response.AccountResponse;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;
import uth.edu.podbooking.domain.workspace.service.WorkSpaceService;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/workspaces")
public class WorkSpaceController {
    private final WorkSpaceService workSpaceService;

    @GetMapping()
    public Response<List<WorkSpaceResponse>> listWorkSpaces() {
        return Response.<List<WorkSpaceResponse>>builder()
                .result(this.workSpaceService.fetchAllWorkSpaces())
                .build();
    }

}
