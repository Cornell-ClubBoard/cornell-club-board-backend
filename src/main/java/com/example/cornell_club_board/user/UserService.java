package com.example.cornell_club_board.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        // Returns a list
        return userRepository.findAll();
    }

    // Used when registering
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            System.out.println("Problem with addUser");
            throw new IllegalStateException("This Username is Taken");
        }
        userRepository.save(user);
        System.out.println("Should have saved?");
    }

    public User findUserByUsernameAndPassword(String email, String password) {
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        if (!userOptional.isPresent()) {
            throw new IllegalStateException("This User Does Not Exist");
        }
        if (!(userOptional.get().getPassword().equals(password))) {
            throw new IllegalStateException("This Password is Incorrect");
        }
        return userOptional.get();
    }

    // Used when deleting account
    public void removeUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("This User does not Exist");
        }
        userRepository.deleteById(id);
    }

    // Change name for account
    public void changeName(Long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with ID " + id + " does not exist"));

        if (name.length() >= 1) {
            user.setName(name);
        }
    }

    // Change password for account
    public void changePassword(Long id, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User with ID " + id + " does not exist"));

        if (password.length() >= 1) {
            user.setPassword(password);
        }
    }

    public User findUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        if (!userOptional.isPresent()) {
            throw new IllegalStateException("This User Does Not Exist");
        }
        return userOptional.get();
    }

    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findUserById(userId);
        if (!userOptional.isPresent()) {
            throw new IllegalStateException("This User Does Not Exist");
        }
        return userOptional.get();
    }
}
