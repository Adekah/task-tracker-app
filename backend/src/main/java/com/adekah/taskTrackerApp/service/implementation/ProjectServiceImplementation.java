package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.dto.ProjectDto;
import com.adekah.taskTrackerApp.entity.Project;
import com.adekah.taskTrackerApp.entity.User;
import com.adekah.taskTrackerApp.repository.ProjectRepository;
import com.adekah.taskTrackerApp.repository.UserRepository;
import com.adekah.taskTrackerApp.service.ProjectService;
import com.adekah.taskTrackerApp.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ProjectServiceImplementation(ProjectRepository projectRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.projectRepository = projectRepository;

        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck != null) {
            throw new IllegalArgumentException("project code already exist");
        }
        Project p = modelMapper.map(project, Project.class);
        User user =userRepository.getOne(project.getManagerId());
        p.setManager(user);



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

//    @Override
//    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
//        Page<Project> data = projectRepository.findAll(pageable);
//        TPage<ProjectDto> response = new TPage<>();
//        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto.class)));
//        return response;
//    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;

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
