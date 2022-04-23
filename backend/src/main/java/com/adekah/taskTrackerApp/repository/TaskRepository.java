package com.adekah.taskTrackerApp.repository;

import com.adekah.taskTrackerApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
