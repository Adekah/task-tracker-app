package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.dto.TaskDto;
import com.adekah.taskTrackerApp.entity.Task;
import com.adekah.taskTrackerApp.repository.TaskRepository;
import com.adekah.taskTrackerApp.service.TaskService;
import com.adekah.taskTrackerApp.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TaskServicelmplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServicelmplementation(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public TaskDto save(TaskDto task) {
        if (task.getDate() == null) {
            throw new IllegalArgumentException("Date Cannot Be Null");
        }
        Task taskDb = modelMapper.map(task, Task.class);
        taskDb = taskRepository.save(taskDb);
        return modelMapper.map(taskDb, TaskDto.class);
    }

    @Override
    public TaskDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<TaskDto> getAllPageable(Pageable pageable) {
        Page<Task> data = taskRepository.findAll(pageable);
        TPage page = new TPage<TaskDto>();
        TaskDto[] dtos = modelMapper.map(data.getContent(), TaskDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(TaskDto task) {
        return null;
    }
}
