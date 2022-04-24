package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.repository.ProjectRepository;
import com.adekah.taskTrackerApp.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServicelmplementation implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServicelmplementation(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project Code Cannot be null!");
        }
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id) {

        Project p=projectRepository.getById(id);
        return modelMapper.map(p,ProjectDto.class);

    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
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
    public Boolean delete(Project project) {
        return null;
    }
}
