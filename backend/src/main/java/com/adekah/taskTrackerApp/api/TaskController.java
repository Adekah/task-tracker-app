package com.adekah.taskTrackerApp.api;



import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.dto.TaskDto;
import com.adekah.taskTrackerApp.service.implementation.TaskServiceImplementation;
import com.adekah.taskTrackerApp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.TaskController.CTRL)
@Api(value = ApiPaths.TaskController.CTRL, description = "Task APIs")
public class TaskController {
    private final TaskServiceImplementation taskServicelmplementation ;

    public TaskController(TaskServiceImplementation taskServicelmplementation) {
        this.taskServicelmplementation = taskServicelmplementation;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = TaskDto.class)
    public ResponseEntity<TaskDto> getById(@PathVariable(value = "id", required = true) Long id) {
        TaskDto taskDto = taskServicelmplementation.getById(id);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = TaskDto.class)
    public ResponseEntity<TaskDto> createProject(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskServicelmplementation.save(taskDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = TaskDto.class)
    public ResponseEntity<TaskDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskServicelmplementation.update(id, taskDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(taskServicelmplementation.delete(id));
    }
}
