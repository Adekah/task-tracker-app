package com.adekah.taskTrackerApp.api;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.service.implementation.ProjectServiceImplementation;
import com.adekah.taskTrackerApp.util.ApiPaths;
import com.adekah.taskTrackerApp.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(ApiPaths.ProjectController.CTRL)
@Api(value = ApiPaths.ProjectController.CTRL, description = "Project APIs")
public class ProjectController {
    private final ProjectServiceImplementation projectServiceImplementation;

    public ProjectController(ProjectServiceImplementation projectServiceImplementation) {
        this.projectServiceImplementation = projectServiceImplementation;
    }

//    @GetMapping("/pagination")
//    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
//    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
//        TPage<ProjectDto> data = projectServiceImplementation.getAllPageable(pageable);
//        return ResponseEntity.ok(data);
//    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImplementation.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjectDto projectDto = projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImplementation.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImplementation.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImplementation.delete(id));
    }
}
