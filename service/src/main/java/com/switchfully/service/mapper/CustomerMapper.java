package com.switchfully.service.mapper;

import com.switchfully.domain.customer.Customer;
import com.switchfully.service.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static Customer dtoToCustomer(CustomerDto customerDto){
        return new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                AddressMapper.dtoToAdress(customerDto.getAddress()),
                customerDto.getPhoneNumber());
    }

    public static CustomerDto customerToDto(Customer customer){
        return new CustomerDto(customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                AddressMapper.addressToDto(customer.getAddress()),
                customer.getPhoneNumber());
    }
}
