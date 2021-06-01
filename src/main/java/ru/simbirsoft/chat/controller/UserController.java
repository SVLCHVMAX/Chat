package ru.simbirsoft.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.simbirsoft.chat.model.User;
import ru.simbirsoft.chat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable("id") long id) {
        User user = userService.findById(id);
        if (user != null) {
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setRole(newUser.getRole());
            userService.save(user);
            return user;
        }
        else {
            newUser.setId(id);
            userService.save(newUser);
            return newUser;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "Deleted user with id - " + id;
    }
}
