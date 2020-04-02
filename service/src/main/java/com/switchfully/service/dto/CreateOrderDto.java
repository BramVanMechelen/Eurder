package com.switchfully.service.dto;

import java.util.List;

public class CreateOrderDto {
    private List<CreateItemGroupDto> itemGroupList;

    public CreateOrderDto() {
    }

    public List<CreateItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}

