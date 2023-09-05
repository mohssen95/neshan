package com.example.foodi.service;

import com.example.foodi.dto.UserDto;
import com.example.foodi.model.User;

import java.util.List;

public interface userService {
    UserDto signupUser(UserDto user);
    UserDto getUserById(long userId);
    UserDto updateUser(Long id,UserDto user);


    void deleteUserById(long userId);
    List<UserDto> getAllUsers();
    List<UserDto> getAllUsersByName(String name);
    User getUserByUsername(String username);
    void editUsername(long id,String username);

}
