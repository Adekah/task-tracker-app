package com.adekah.taskTrackerApp.dto;

import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.entity.TaskStatus;
import com.adekah.taskTrackerApp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private TaskStatus taskStatus;
    private UserDto assignee;
    private ProjectDto project;
}
