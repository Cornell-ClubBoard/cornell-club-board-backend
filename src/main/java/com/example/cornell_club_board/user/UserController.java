package com.example.cornell_club_board.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/login_user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public Map<String, String> getEmailById(@RequestHeader("UserId") Long userId) {
        User user = userService.findUserById(userId);
        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("email", user.getEmail());
        userDetails.put("password", user.getPassword());
        return userDetails;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestHeader("Email") String email,
                         @RequestHeader("Password") String password) {
        System.out.println("Register method called with email: " + email + " and password: " + password);
        userService.addNewUser(new User(email, password));
        System.out.println("Register run");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestHeader("Email") String email,
                      @RequestHeader("Password") String password) {
        return userService.findUserByUsernameAndPassword(email, password);
    }

}
