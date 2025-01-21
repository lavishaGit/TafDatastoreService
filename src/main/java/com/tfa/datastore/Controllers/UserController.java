package com.tfa.datastore.Controllers;

import com.tfa.datastore.Models.Users;
import com.tfa.datastore.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/datastore/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) throws Exception {
        Optional<Users> userOptional = Optional.ofNullable( userService.getUserById(id));
                if (userOptional.isPresent()) {
            return new  ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            // Return NOT_FOUND if the user does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
