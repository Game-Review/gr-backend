package dev.grbackend.services;

import dev.grbackend.models.User;
import dev.grbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getUsers(){
       return (ArrayList<User>) userRepository.findAll();
    }

    public ResponseEntity<User> getByUserName(String userName, String password){
        User userObject = userRepository.findByUserName(userName);
        if(userObject != null){
            if(userObject.getPassword().equals(password)){
                return new ResponseEntity<>(userObject, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
