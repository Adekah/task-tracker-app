package com.adekah.taskTrackerApp.repository;

import com.adekah.taskTrackerApp.entity.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory,Long> {
}
