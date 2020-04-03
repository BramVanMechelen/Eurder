package com.switchfully.service.dto;

import java.time.LocalDate;

public class ItemGroupDto {
    private String name;
    private int amount;
    private String shippingDate;


    public ItemGroupDto(String name, int amount, String shippingDate) {
        this.name = name;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getShippingDate() {
       return shippingDate;
    }
}
