package com.adekah.taskTrackerApp.service.implementation;

import com.adekah.taskTrackerApp.dto.UserDto;
import com.adekah.taskTrackerApp.entity.User;
import com.adekah.taskTrackerApp.repository.UserRepository;
import com.adekah.taskTrackerApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServicelmplementation implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServicelmplementation(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto user) {
        User u = modelMapper.map(user, User.class);
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        u = userRepository.save(u);
        return user;
    }

    @Override
    public UserDto getById(Long id) {
        User u = userRepository.getOne(id);
        return modelMapper.map(u, UserDto.class);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDto getByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    public List<UserDto> getAll() {

        List<User> users = userRepository.findAll();

        return Arrays.asList(modelMapper.map(users, UserDto[].class));

    }
}
