package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.entity.Task;
import com.adekah.taskTrackerApp.entity.TaskHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskHistoryService {

    TaskHistory save(TaskHistory taskHistory);

    TaskHistory getById(Long id);

    Page<TaskHistory> getAllPageable(Pageable pageable);

    Boolean delete(TaskHistory taskHistory);
}
