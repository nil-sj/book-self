package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dto.UserDto;
import com.bookself.bookself_api.mappers.UserMapper;
import com.bookself.bookself_api.models.User;
import com.bookself.bookself_api.services.UserService;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers()
                              .stream()
                              .map(UserMapper::toDto)
                              .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    // Get user by Id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(value -> ResponseEntity.ok(UserMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findUserByEmail(email);
        return user.map(value -> ResponseEntity.ok(UserMapper.toDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Create a new user
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User newUser = userService.createUser(user);
            return ResponseEntity.ok(newUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Update user detail
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        try {
            User updateUser = userService.updateUser(id, UserMapper.toEntity(userDto));
            return ResponseEntity.ok(UserMapper.toDto(updateUser));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Delete a user by Id
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    //Login user and create session
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Optional<User> user = userService.findUserByEmail(email);

        if(user.isPresent() && userService.checkPassword(user.get(), password)) {
            session.setAttribute("user", UserMapper.toDto(user.get()));
            return ResponseEntity.ok("Login Successfull");
        }

        return ResponseEntity.status(401).body("Invalid Credentials");
    }

    //Logout user
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}
