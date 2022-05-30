package com.adekah.taskTrackerApp.api;

import com.adekah.taskTrackerApp.dto.UserDto;
import com.adekah.taskTrackerApp.service.implementation.UserServicelmplementation;
import com.adekah.taskTrackerApp.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserController.CTRL)
@Api(value=ApiPaths.UserController.CTRL,description = "User Api")
@CrossOrigin
public class UserController {
    private final UserServicelmplementation userServicelmplementation ;

    public UserController(UserServicelmplementation userServicelmplementation) {
        this.userServicelmplementation = userServicelmplementation;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    public ResponseEntity<UserDto> getById(@PathVariable(value = "id", required = true) Long id) {
        UserDto userDto = userServicelmplementation.getById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping()
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> data=userServicelmplementation.getAll();
        return ResponseEntity.ok(data);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = UserDto.class)
    public ResponseEntity<UserDto> createProject(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userServicelmplementation.save(userDto));
    }

//    @PutMapping("/{id}")
//    @ApiOperation(value = "Update Operation", response = UserDto.class)
//    public ResponseEntity<UserDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody UserDto userDto) {
//        return ResponseEntity.ok(userServicelmplementation.update(id, userDto));
//    }
//
//    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete Operation", response = boolean.class)
//    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
//        return ResponseEntity.ok(userServicelmplementation.delete(id));
//    }
}
