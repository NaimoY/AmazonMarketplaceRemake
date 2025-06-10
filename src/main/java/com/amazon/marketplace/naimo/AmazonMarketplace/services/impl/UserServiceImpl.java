package com.amazon.marketplace.naimo.AmazonMarketplace.services.impl;

import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.User;
import com.amazon.marketplace.naimo.AmazonMarketplace.mappers.UserMapper;
import com.amazon.marketplace.naimo.AmazonMarketplace.repositories.UserRepository;
import com.amazon.marketplace.naimo.AmazonMarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        /*
        Step 1: Create a JPA User (entity)
        Step 2: Tell the UserRepository to store the JPA User
        Step 3: Take the JPA User that the DB responds with and
                send that back to the controller.
         */
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = userRepository.findAll()
                .stream().map(userMapper::mapToUserDto).toList();

        return userDtos;
    }

    @Override
    public UserDto getUserByID(int id) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("User with this ID doesn't exist") );

        return userMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUserByID(UserDto userDto, int id) {
        /*
        1. retrieve a JPA user by the ID passed
        2. Use setters to update the JPA by using getters on the userDto
        3. Save the updated JPA user back to the database
        4. return the response from db back to the Controller

         */
        User user = userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("User with this ID doesn't exist") );
        user.setFirstName(userDto.getFristName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        //user.setUpdatedAt(userDto.getUpdatedAt());

        User savedUser = userRepository.save(user);

        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public String deleteUserByID(int id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Deleted user with ID " + id;
    }
        return "No such user with ID" + id;
    }
}
