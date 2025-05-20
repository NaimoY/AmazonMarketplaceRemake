package com.amazon.marketplace.naimo.AmazonMarketplace.mappers;

import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User MapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFristName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }
    public UserDto mapToUserDto(User user){
        return null;
    }
}
