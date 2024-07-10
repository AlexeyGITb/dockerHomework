package ru.alex.dockerhomework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.dockerhomework.entity.User;
import ru.alex.dockerhomework.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        log.info("UserController created");
        this.userRepository = userRepository;
    }

    @GetMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam(value = "id") Long id) {
       return userRepository.getUser(id);
    }

    @PostMapping(path ="",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userRepository.addUser(user.getName(), user.getAge());
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        userRepository.deleteUser(id);
        return ResponseEntity.ok("DELETED");
    }
}
