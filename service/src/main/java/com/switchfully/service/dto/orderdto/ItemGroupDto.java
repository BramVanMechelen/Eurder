package com.switchfully.service.dto.orderdto;

import java.time.LocalDate;

public class ItemGroupDto {
    private String name;
    private int amount;
    private String shippingDate;
    private double price;


    public ItemGroupDto(String name, int amount, String shippingDate, double price) {
        this.name = name;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
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

    public double getPrice() {
        return price;
    }
}
