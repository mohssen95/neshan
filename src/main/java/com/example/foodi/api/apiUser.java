package com.example.foodi.api;


import com.example.foodi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class apiUser {

    @Autowired
    com.example.foodi.service.userService userService;


    @GetMapping
    ResponseEntity<?> getUsers(){
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }

    @PostMapping(path = "/add")
    ResponseEntity<?> addUser(@RequestBody User user){
        try {
            User savedUser = userService.addUser(user);
            final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build()
                    .expand(savedUser.getUserId()).toUri();

            return ResponseEntity.created(location).body(savedUser);
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save User" + e.getMessage());
        }
    }

    // Get user by id
    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable("id") long userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable("id") long id ,@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.updateUser(id,user));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("User with id " + userId + " successfully deleted");
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }


}
