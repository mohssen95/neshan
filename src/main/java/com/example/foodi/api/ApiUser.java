package com.example.foodi.api;


import com.example.foodi.dto.UserDto;
import com.example.foodi.model.Order;
import com.example.foodi.model.User;
import com.example.foodi.service.OrderService;
import com.example.foodi.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class ApiUser {

    @Autowired
    userService userService;
    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{id}")
    ResponseEntity<?> getOrder(@PathVariable long id) {
        try {
            Optional<Order> order = orderService.getOrder(id);
            System.out.println(order.get().toString());
            return ResponseEntity.ok(order.get());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }

    @GetMapping("users")
    ResponseEntity<?> getUsers() {
        try {
            List<UserDto> users = userService.getAllUsers();
            System.out.println("here");
            return ResponseEntity.ok(users);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching " + e.getMessage());
        }
    }

    @PostMapping(path = "/add")
    ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User savedUser = userService.addUser(user);
            final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build()
                    .expand(savedUser.getUserId()).toUri();

            return ResponseEntity.created(location).body(savedUser);
        } catch (Exception e) {
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

    // Get user by id
    @GetMapping("/u/{username}")
    ResponseEntity<?> getUserByUserName(@PathVariable("username") String username) {
        try {
            System.out.println("hereeeeeeeeeeeee");
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("User with id " + userId + " successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/users/{id}/username")
    void editUsername(@PathVariable("id") long userId,@RequestParam("uname") String username){
             userService.editUsername(userId,username);
    }
}
