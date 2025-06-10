package com.amazon.marketplace.naimo.AmazonMarketplace.controllers;
import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserByID(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable int id, @RequestBody UserDto userDto){

        UserDto updatedUserDto = userService.updateUserByID(userDto, id);
        return ResponseEntity.ok(updatedUserDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.deleteUserByID(id));
    }
}