package com.adekah.taskTrackerApp.api;



import com.adekah.taskTrackerApp.dto.TaskDto;
import com.adekah.taskTrackerApp.service.implementation.TaskServiceImplementation;
import com.adekah.taskTrackerApp.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.TaskController.CTRL)
public class TaskController {
    private final TaskServiceImplementation taskServicelmplementation ;

    public TaskController(TaskServiceImplementation taskServicelmplementation) {
        this.taskServicelmplementation = taskServicelmplementation;
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable(value = "id", required = true) Long id) {
        TaskDto taskDto = taskServicelmplementation.getById(id);
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createProject(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskServicelmplementation.save(taskDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskServicelmplementation.update(id, taskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(taskServicelmplementation.delete(id));
    }
}
