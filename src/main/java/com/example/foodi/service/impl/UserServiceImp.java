package com.example.foodi.service.impl;

import com.example.foodi.model.User;
import com.example.foodi.repo.UserRepository;
import com.example.foodi.service.userService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements userService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String userame){
        return userRepository.findUserByUserName(userame);

    }

    @Override
    public void editUsername(long id, String username) {
         userRepository.editUsername(id, username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }


    @Override
    public User signupUser(User user) {
        User newUser=(user);
        return (userRepository.save(newUser));
    }

    @Override
    public User getUserById(long userId) {
        return  (userRepository.findUserByUserId(userId));
    }


    @Override
    public User updateUser(Long id,User user) {
        User user1=(user);
        user1.setUserId(id);
        return (userRepository.save(user1));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();


        return users;    }
    @Override
    public List<User> getAllUsersByName(String name) {

        return
        userRepository.getAllByName(name);
    }


}
