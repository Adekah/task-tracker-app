package com.adekah.taskTrackerApp.api;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.service.implementation.ProjectServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectServiceImplementation projectServiceImplementation;

    public ProjectController(ProjectServiceImplementation projectServiceImplementation) {
        this.projectServiceImplementation = projectServiceImplementation;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        ProjectDto projectDto = projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectServiceImplementation.save(projectDto));
    }
}
