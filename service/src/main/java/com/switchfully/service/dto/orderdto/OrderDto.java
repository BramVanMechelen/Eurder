package com.switchfully.service.dto.orderdto;

import java.util.List;


public class OrderDto {
    private int orderNumber;
    private List<ItemGroupDto> itemGroupList;
    private double price;


  public OrderDto(int orderNumber, List<ItemGroupDto> itemGroupList, double price) {
      this.orderNumber = orderNumber;
        this.itemGroupList = itemGroupList;
        this.price = price;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }

    public double getPrice() {
        return price;
    }
}
