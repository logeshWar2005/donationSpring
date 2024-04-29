package com.example.donation.service;

import java.util.*;
import com.example.donation.model.User;
import com.example.donation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // GET Methods
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }
    
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    // POST Method
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // PUT Methods
    public User updateUsername(String email, String newUsername) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(newUsername);
            return userRepo.save(user);
        } else {
            return null;
        }
    }

    public User updatePassword(String email, String newPassword) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(newPassword);
            return userRepo.save(user);
        } else {
            return null;
        }
    }

    public User updatePhoneNumber(String email, String newPhoneNumber) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPhoneNumber(newPhoneNumber);
            return userRepo.save(user);
        } else {
            return null;
        }
    }

    // DELETE Methods
    public boolean deleteUserByEmail(String email) {
      Optional<User> user = userRepo.findByEmail(email);
      if (user.isPresent()) {
          userRepo.delete(user.get());
          return true;
      }
      return false;
    }

    public boolean deleteUserByUsername(String username) {
      Optional<User> user = userRepo.findByUsername(username);
      if (user.isPresent()) {
          userRepo.delete(user.get());
          return true;
      }
      return false;
    }

    public boolean deleteUserById(int userId) {
      Optional<User> user = userRepo.findById(userId);
      if (user.isPresent()) {
          userRepo.delete(user.get());
          return true;
      }
      return false;
    }
}
