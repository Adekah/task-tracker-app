package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

   Project getByProjectCode(String projectCode);

    List<Project>getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto projectDto);
}
