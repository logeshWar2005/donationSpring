package com.example.donation.controller;

import java.util.*;
import com.example.donation.model.User;
import com.example.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET Methods
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // POST Method
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // PUT Methods
    @PutMapping("/updateUsername/{email}")
    public ResponseEntity<User> updateUsername(@PathVariable String email, @RequestParam String newUsername) {
        User updatedUser = userService.updateUsername(email, newUsername);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @PutMapping("/updatePassword/{email}")
    public ResponseEntity<User> updatePassword(@PathVariable String email, @RequestParam String newPassword) {
        User updatedUser = userService.updatePassword(email, newPassword);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @PutMapping("/updatePhoneNumber/{email}")
    public ResponseEntity<User> updatePhoneNumber(@PathVariable String email, @RequestParam String newPhoneNumber) {
        User updatedUser = userService.updatePhoneNumber(email, newPhoneNumber);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    // DELETE Methods
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Boolean> deleteUserByEmail(@PathVariable String email) {
        boolean deleted = userService.deleteUserByEmail(email);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<Boolean> deleteUserByUsername(@PathVariable String username) {
        boolean deleted = userService.deleteUserByUsername(username);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/id/{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable int userId) {
        boolean deleted = userService.deleteUserById(userId);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }
}
