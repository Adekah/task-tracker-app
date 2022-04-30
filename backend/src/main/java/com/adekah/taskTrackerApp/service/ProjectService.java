package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.entity.TaskHistory;
import com.adekah.taskTrackerApp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

   Project getByProjectCode(String projectCode);

    List<Project>getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
