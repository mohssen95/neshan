package com.example.foodi.service.impl;

import com.example.foodi.dto.UserDto;
import com.example.foodi.dto.impl.AutoUserMapper;
import com.example.foodi.model.User;
import com.example.foodi.repo.UserRepoitory;
import com.example.foodi.service.userService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImp implements userService {
    @Autowired
    UserRepoitory userRepository;

    public User getUserByUsername(String userame){
        return userRepository.findUserByUserName(userame);

    }

    @Override
    public void editUsername(long id, String username) {
         userRepository.editUsername(id, username);
    }


    @Override
    public UserDto signupUser(UserDto user) {
        User newUser=AutoUserMapper.MAPPER.mapToUser(user);
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(newUser));
    }

    @Override
    public UserDto getUserById(long userId) {
        return  AutoUserMapper.MAPPER.mapToUserDto(userRepository.findUserByUserId(userId));
    }


    @Override
    public UserDto updateUser(Long id,UserDto user) {
        User user1=AutoUserMapper.MAPPER.mapToUser(user);
        user1.setUserId(id);
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(user1));
    }

    @Override
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();


        return users.stream().map(user->AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());    }
    @Override
    public List<UserDto> getAllUsersByName(String name) {

        return
        userRepository.getAllByName(name).stream()
                .map(u->AutoUserMapper.MAPPER.mapToUserDto(u))
                .collect(Collectors.toList());
    }


}
