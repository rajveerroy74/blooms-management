package in.rajveer.blooms.services;

import in.rajveer.blooms.models.User;
import in.rajveer.blooms.repositories.UserRepository;
import in.rajveer.blooms.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Error: Username " + user.getUsername() + " already exists!";
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Error: Email " + user.getEmail() + " is already registered!";
        }

        User savedUser = userRepository.save(user);
        return "Success: User registered with ID: " + savedUser.getId();
    }

    public UserResponse loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            User u = user.get();
            return new UserResponse(
                    u.getUsername(),
                    u.getEmail(),
                    u.getName(),
                    u.getProfileUrl(),
                    u.getPhoneNumber());
        }
        return null;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}