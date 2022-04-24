package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.dto.TaskDto;
import com.adekah.taskTrackerApp.entity.Task;
import com.adekah.taskTrackerApp.entity.TaskHistory;
import com.adekah.taskTrackerApp.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskDto save(TaskDto task);

    TaskDto getById(Long id);

    TPage<TaskDto> getAllPageable(Pageable pageable);

    Boolean delete(TaskDto task);
}
