package com.amazon.marketplace.naimo.AmazonMarketplace.services;

import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserByID(int id);
    UserDto updateUserByID(UserDto userDto, int id);
    String deleteUserByID(int id);

}
