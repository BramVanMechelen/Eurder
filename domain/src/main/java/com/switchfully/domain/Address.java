package com.switchfully.domain;

public class Address {
    private String streetName;
    private String houseNumber;
    private String zipcode;
    private String city;

    public Address(String streetName, String houseNumber, String zipcode, String city) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }
}