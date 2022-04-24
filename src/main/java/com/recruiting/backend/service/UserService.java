package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.User;
import com.recruiting.backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) { this.userRepo = userRepo; }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " is not found."));

    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email: " + email + " is not found."));
    }

    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username: " + username + " is not found."));
    }

    public void deleteUserByUsername(String username) {
        userRepo.deleteUserByUsername(username);
    }

    public void deleteUserById(Long id) {
        userRepo.deleteUserById(id);
    }
}
