package com.switchfully.api;


import com.switchfully.domain.repositiories.CustomerRepository;
import com.switchfully.service.dto.customerdto.CustomerDto;

import com.switchfully.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = CustomerController.CUSTOMER_CONTROLLER_RESOURCE_URL)
public class CustomerController {
    public static final String CUSTOMER_CONTROLLER_RESOURCE_URL = "/customer";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(CREATED)
    public CustomerDto registerNewCustomer(@RequestBody CustomerDto customerDto){
        return CustomerMapper.customerToDto(customerRepository.registerCustomer(CustomerMapper.dtoToCustomer(customerDto)));
    }

    @GetMapping( produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public List<CustomerDto> getAllCustomers(){
        return customerRepository.getCustomerList().stream()
                .map(CustomerMapper::customerToDto)
                .collect(Collectors.toList());
    }


    @GetMapping(path = "/test", produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public String testString(){
       return "hello test";
    }
}
