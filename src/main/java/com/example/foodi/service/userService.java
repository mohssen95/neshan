package com.example.foodi.service;

import com.example.foodi.model.User;

import java.util.List;
import java.util.Optional;

public interface userService {
    void editUsername(long id, String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User signupUser(User user);
    User getUserById(long userId);
    User updateUser(Long id,User user);
    Optional<User> findByUsername(String username);

    void deleteUserById(long userId);
    List<User> getAllUsers();

    List<User> getAllUsersByName(String name);
}
