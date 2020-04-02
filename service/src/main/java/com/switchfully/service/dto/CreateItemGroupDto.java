package com.switchfully.service.dto;


public class CreateItemGroupDto {
    private String name;
    private int amount;


    public CreateItemGroupDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
