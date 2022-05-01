package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.entity.TaskHistory;
import com.adekah.taskTrackerApp.repository.TaskHistoryRepository;
import com.adekah.taskTrackerApp.service.TaskHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskHistoryServiceImplementation implements TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;

    public TaskHistoryServiceImplementation(TaskHistoryRepository taskHistoryRepository) {
        this.taskHistoryRepository = taskHistoryRepository;
    }


    @Override
    public TaskHistory save(TaskHistory taskHistory) {

        if (taskHistory.getDate() == null) {
            throw new IllegalArgumentException("Task Date Cannot be null!");
        }
        taskHistory = taskHistoryRepository.save(taskHistory);
        return taskHistory;
    }

    @Override
    public TaskHistory getById(Long id) {
        return taskHistoryRepository.getOne(id);
    }

    @Override
    public Page<TaskHistory> getAllPageable(Pageable pageable) {
        return taskHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(TaskHistory taskHistory) {
        taskHistoryRepository.delete(taskHistory);
        return Boolean.TRUE;
    }
}
