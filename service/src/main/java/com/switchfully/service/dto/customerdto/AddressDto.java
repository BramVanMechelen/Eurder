package com.switchfully.service.dto.customerdto;


public class AddressDto {
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;

    public AddressDto(String streetName, String houseNumber, String zipCode, String city) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
