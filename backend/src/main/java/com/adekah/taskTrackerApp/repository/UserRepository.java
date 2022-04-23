package com.adekah.taskTrackerApp.repository;

import com.adekah.taskTrackerApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

    User findByUserName(String username);
}
