package com.switchfully.service.mapper;

import com.switchfully.service.dto.AddressDto;
import com.switchfully.domain.*;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public static Address dtoToAdress(AddressDto addressDto){
        return new Address(addressDto.getStreetName(), addressDto.getHouseNumber(), addressDto.getZipCode(), addressDto.getCity());
    }

    public static AddressDto addressToDto(Address address){
        return new AddressDto(address.getStreetName(), address.getHouseNumber(), address.getZipcode(), address.getCity());
    }
}
