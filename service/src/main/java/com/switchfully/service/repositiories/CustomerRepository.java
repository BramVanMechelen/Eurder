package com.switchfully.service.repositiories;

import com.switchfully.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository {

    private final List<Customer> customerList;

    @Autowired
    public CustomerRepository() {
        this.customerList = new ArrayList<>();
    }

    public Customer registerCustomer(Customer customer) {
        customerList.add(customer);
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
