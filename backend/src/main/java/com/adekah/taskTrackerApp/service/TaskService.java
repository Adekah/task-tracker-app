package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.dto.TaskDto;
import com.adekah.taskTrackerApp.util.TPage;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDto save(TaskDto task);

    TaskDto getById(Long id);

    TPage<TaskDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    TaskDto update(Long id, TaskDto taskDto);
}
