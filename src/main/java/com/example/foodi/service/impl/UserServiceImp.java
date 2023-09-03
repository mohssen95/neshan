package com.example.foodi.service.impl;

import com.example.foodi.dto.AutoUserMapper;
import com.example.foodi.dto.UserDto;
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
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long userId) {
        return (User) userRepository.findUserByUserId(userId);
    }


    @Override
    public User updateUser(Long id,User user) {

        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long userId) {
        verifyUser(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();


        return users.stream().map(user->AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());    }
    @Override
    public List<User> getAllUsersByName(String name) {
        return userRepository.getAllByName(name);
    }



    User verifyUser(long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("No User found for the given id - " + userId));
        return user;
    }

}
