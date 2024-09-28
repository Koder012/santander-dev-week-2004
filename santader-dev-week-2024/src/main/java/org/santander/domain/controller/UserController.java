package org.santander.domain.controller;

import org.santander.domain.model.User;
import org.santander.domain.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        var user =  userService.findById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToSave){
        var userCreated = userService.create(userToSave);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userToSave.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }


}
