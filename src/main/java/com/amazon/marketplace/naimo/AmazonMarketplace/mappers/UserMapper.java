package com.amazon.marketplace.naimo.AmazonMarketplace.mappers;

import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final AddressMapper addressMapper;

    public User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setProfilePictureUrl(userDto.getProfilePictureUrl());

        if(userDto.getAddressDto() != null){
            Address address = addressMapper.mapToAddress(userDto.getAddressDto(),user);
            user.setAddress(address);
        }

        return user;
    }
    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        userDto.setProfilePictureUrl(user.getProfilePictureUrl());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());

        if(user.getAddress() !=null){
            AddressDto addressDto = addressMapper.mapToAddressDto(user.getAddress());
            userDto.setAddressDto(addressDto);
        }
        return userDto;


    }

}
