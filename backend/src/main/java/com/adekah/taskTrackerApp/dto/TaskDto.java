package com.adekah.taskTrackerApp.dto;

import com.adekah.taskTrackerApp.entity.TaskStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    @ApiModelProperty(required = true, value = "ID")
    private Long id;
    @ApiModelProperty(required = true, value = "Description")
    private String description;
    @ApiModelProperty(required = true, value = "Task Details")
    private String details;
    @ApiModelProperty(required = true, value = "Date")
    private Date date;
    @ApiModelProperty(required = true, value = "Task Status")
    private TaskStatus taskStatus;
    @ApiModelProperty(required = true, value = "Assignee")
    private UserDto assignee;
    @ApiModelProperty(required = true, value = "Project")
    private ProjectDto project;
}
