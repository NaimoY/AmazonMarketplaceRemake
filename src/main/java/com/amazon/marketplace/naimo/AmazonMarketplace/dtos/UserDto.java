package com.amazon.marketplace.naimo.AmazonMarketplace.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/*
 this is a regular java object. WHen the controller
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;
    private String profilePictureUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //private LocalDateTime createdAt = LocalDateTime.now();
    //private LocalDateTime updatedAt = LocalDateTime.now();
   private AddressDto addressDto;
}
