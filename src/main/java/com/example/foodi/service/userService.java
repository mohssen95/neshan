package com.example.foodi.service;

import com.example.foodi.model.User;
import com.example.foodi.dto.UserDto;

import java.util.List;

public interface userService {
    User addUser(User user);
    User getUserById(long userId);
    User updateUser(Long id,User user);


    void deleteUserById(long userId);
    List<UserDto> getAllUsers();
    List<User> getAllUsersByName(String name);
    User getUserByUsername(String username);
    void editUsername(long id,String username);
}
