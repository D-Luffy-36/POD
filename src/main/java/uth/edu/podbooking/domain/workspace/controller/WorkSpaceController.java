package uth.edu.podbooking.domain.workspace.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import uth.edu.podbooking.common.Response;
import uth.edu.podbooking.domain.workspace.dto.WorkSpaceResponse;
import uth.edu.podbooking.domain.workspace.service.WorkSpaceService;

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

    @GetMapping("/{id}")
    public Response<WorkSpaceResponse> detail(@PathVariable Long id) {
        Optional<WorkSpaceResponse> workSpaceResponse = this.workSpaceService.fetchWorkSpace(id);
        if(workSpaceResponse.isEmpty()) {
            return Response.<WorkSpaceResponse>builder()
                    .message("NOT FOUND")
                    .build();
        }
        return Response.<WorkSpaceResponse>builder().result(workSpaceResponse.get()).build();
    }

}
