package in.rajveer.blooms.controller;

import in.rajveer.blooms.dto.UserRequest;
import in.rajveer.blooms.dto.UserResponse;
import in.rajveer.blooms.models.User;
import in.rajveer.blooms.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest req) {
        User user = new User(
                req.getUsername(),
                req.getEmail(),
                req.getName(),
                req.getPassword(),
                req.getProfileUrl(),
                req.getPhoneNumber()
        );
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public UserResponse loginUser(@RequestParam String username, @RequestParam String password) {
        return service.loginUser(username, password);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAll();
    }
}