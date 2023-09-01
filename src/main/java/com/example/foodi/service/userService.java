package com.example.foodi.service;

import com.example.foodi.model.User;

import java.util.List;

public interface userService {
    User addUser(User user);
    User getUserById(long userId);
    User updateUser(Long id,User user);


    void deleteUserById(long userId);
    List<User> getAllUsers();
    List<User> getAllUsersByName(String name);
}
