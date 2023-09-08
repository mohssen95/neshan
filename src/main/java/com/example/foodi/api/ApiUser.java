package com.example.foodi.api;

import com.example.foodi.model.User;
import com.example.foodi.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/users")
public class ApiUser {

    @Autowired
    userService userService;

    @GetMapping()
    ResponseEntity<List<User>> getUsers() {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);

    }

    @PostMapping(path = "/signup")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.signupUser(user));
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // must convert to signin username password in  request body
//    @GetMapping("/signin}")
//    ResponseEntity<?> getUserByUserName(@PathVariable("username") String username) {
//        try {
//            System.out.println("hereeeeeeeeeeeee");
//            User user = userService.getUserByUsername(username);
//            return ResponseEntity.ok(user);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
//        }
//    }

    @PutMapping("/update/{id}")
    ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
            User response=userService.updateUser(id, user);
            return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("User with id " + userId + " successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }


}
