package com.switchfully.service.dto;

import java.util.List;


public class OrderDto {
    private int orderNumber;
    private List<ItemGroupDto> itemGroupList;


  public OrderDto(int orderNumber, List<ItemGroupDto> itemGroupList) {
      this.orderNumber = orderNumber;
        this.itemGroupList = itemGroupList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }
}
