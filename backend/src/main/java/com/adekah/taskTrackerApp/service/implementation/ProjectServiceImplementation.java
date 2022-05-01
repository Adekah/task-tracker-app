package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.repository.ProjectRepository;
import com.adekah.taskTrackerApp.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImplementation(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null) {
            throw new IllegalArgumentException("project code already exist");
        }
        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);

    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectDB = projectRepository.getOne(id);
        if (projectDB == null) {
            throw new IllegalArgumentException("project not found ID: " + id);
        }
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);
        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code already Exist");
        }
        projectDB.setProjectCode(projectDto.getProjectCode());
        projectDB.setProjectName(projectDto.getProjectName());
        projectRepository.save(projectDB);
        return modelMapper.map(projectDB, ProjectDto.class);
    }
}
