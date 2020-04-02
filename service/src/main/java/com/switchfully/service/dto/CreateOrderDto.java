package com.switchfully.service.dto;

import java.util.List;

public class CreateOrderDto {
    private List<CreateItemGroupDto> itemGroupList;

    public CreateOrderDto(List<CreateItemGroupDto> itemGroupList) {
        this.itemGroupList = itemGroupList;
    }

    public List<CreateItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}
