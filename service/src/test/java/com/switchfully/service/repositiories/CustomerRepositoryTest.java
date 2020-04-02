package com.switchfully.service.repositiories;

import com.switchfully.domain.customer.Address;
import com.switchfully.domain.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerRepositoryTest {
    Address thuis = new Address("Sint-Antoniusstraat", "1","2000", "Antwerp" );
    Customer bram = new Customer("Bram", "Van Mechelen","email", thuis, "04/");
    Customer steven = new Customer("Steven", "Van Mechelen","email", thuis, "04/");
    CustomerRepository customerRepository = new CustomerRepository();

    @Test
    void registerCustomerTest() {
        customerRepository.registerCustomer(bram);
        Assertions.assertTrue(customerRepository.getCustomerList().contains(bram));
    }
}