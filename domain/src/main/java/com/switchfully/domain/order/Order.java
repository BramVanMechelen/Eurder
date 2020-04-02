package com.switchfully.domain.order;

import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private List<ItemGroup> itemGroupList;
    private static int orderCounter = 0;

    public Order(List<ItemGroup> itemGroupList) {
        this.orderNumber = ++orderCounter;
        this.itemGroupList = itemGroupList;

    }

    public void addItemToOrder(String name, int amount){
        ItemGroup itemGroup = new ItemGroup(name, amount);
        itemGroupList.add(itemGroup);
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
