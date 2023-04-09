package dev.grbackend.controllers;

import dev.grbackend.models.User;
import dev.grbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ArrayList<User> getUsers(){
       return userService.getUsers();
    }
    @RequestMapping(params = {"userName","password"} )
    public ResponseEntity<User> getUser (@RequestParam String userName, @RequestParam String password){
        return userService.getByUserName(userName, password);
    }
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }
}
