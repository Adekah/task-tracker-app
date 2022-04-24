package com.adekah.taskTrackerApp.api;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {

        try {
            ProjectDto projectDto = projectService.getById(id);
            return ResponseEntity.ok(projectDto);
        }catch (Exception e){
            throw e;
        }


    }
}
