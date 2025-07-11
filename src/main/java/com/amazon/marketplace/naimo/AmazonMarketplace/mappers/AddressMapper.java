package com.amazon.marketplace.naimo.AmazonMarketplace.mappers;

import com.amazon.marketplace.naimo.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.naimo.AmazonMarketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address mapToAddress(AddressDto addressDto, User user) {
        Address address = new Address();

        address.setUser(user);
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCountry(addressDto.getCountry());

        return address;
    }

    public AddressDto mapToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setUserId(address.getUser().getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCountry(address.getCountry());

        //Bug fix: set Created and Updated @
        addressDto.setCreatedAt(address.getCreatedAt());
        addressDto.setUpdatedAt(address.getUpdatedAt());

        return addressDto;
    }
}