package com.switchfully.service.dto.orderdto;

import com.switchfully.service.dto.orderdto.CreateItemGroupDto;

import java.util.List;

public class CreateOrderDto {
    private List<CreateItemGroupDto> itemGroupList;

    public CreateOrderDto() {
    }

    public List<CreateItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}

