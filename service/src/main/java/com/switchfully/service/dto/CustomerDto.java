package com.switchfully.service.dto;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto adress;
    private String phoneNumber;

    public CustomerDto(String firstName, String lastName, String email, AddressDto adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public AddressDto getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
