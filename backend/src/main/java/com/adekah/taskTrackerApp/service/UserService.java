package com.adekah.taskTrackerApp.service;

import com.adekah.taskTrackerApp.dto.UserDto;
import com.adekah.taskTrackerApp.entity.Task;
import com.adekah.taskTrackerApp.entity.TaskHistory;
import com.adekah.taskTrackerApp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    UserDto getByUserName(String username);

    Boolean delete(User user);
}
