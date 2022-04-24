package com.recruiting.backend.controller;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.User;
import com.recruiting.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> lst = userService.findAllUsers();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @PostMapping("/id")
    public ResponseEntity<User> getUserById(@RequestParam("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
        User user = userService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/username")
    public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username) {
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            userService.findUserByUsername(user.getUsername());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (UserNotFoundException e) { }
        try {
            userService.findUserByEmail(user.getEmail());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (UserNotFoundException e) { }
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete/id")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete/username")
    public ResponseEntity<?> deleteUser(@RequestParam("username") String username) {
        userService.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestParam("username") String username,
                                         @RequestParam("passwordHash") String passwordHash) {
        User user = userService.findUserByUsername(username);
        if (user.getPasswordHash().equals(passwordHash)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Password does not match", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFoundException(UserNotFoundException err) {
        Error error = new Error(err.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
