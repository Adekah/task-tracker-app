package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.entity.User;
import com.adekah.taskTrackerApp.repository.UserRepository;
import com.adekah.taskTrackerApp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmplementation implements UserService {

    private final UserRepository userRepository;

    public UserServicelmplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }
}
