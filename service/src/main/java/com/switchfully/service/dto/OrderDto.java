package com.switchfully.service.dto;

import java.util.List;


public class OrderDto {
    private int orderNumber;
    private List<CreateItemGroupDto> itemGroupList;


  public OrderDto(int orderNumber, List<CreateItemGroupDto> itemGroupList) {
      this.orderNumber = orderNumber;
        this.itemGroupList = itemGroupList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<CreateItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}
