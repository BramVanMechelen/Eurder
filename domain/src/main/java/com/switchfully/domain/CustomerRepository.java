package com.switchfully.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository {

    private final List<Customer> customerList;

    @Autowired
    public CustomerRepository(){this.customerList = new ArrayList<>();}

    public void registerCustomer(Customer customer){
        customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
