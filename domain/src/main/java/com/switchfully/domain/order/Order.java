package com.switchfully.domain.order;

import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private int orderNumber;
    private List<ItemGroup> itemGroupList;
    private static int orderCounter = 0;
    private double totalPrice;

    public Order(List<ItemGroup> itemGroupList) {
        this.orderNumber = ++orderCounter;
        this.itemGroupList = itemGroupList;
        this.totalPrice = getTotalPriceOfItemGroupList(itemGroupList);
    }

    public double getTotalPriceOfItemGroupList(List<ItemGroup> itemGroupList){
        double totalPrice = 0;
        for (ItemGroup itemGroup: itemGroupList){
            totalPrice = totalPrice + itemGroup.getPrice();
        }
        return totalPrice;
    }

    public void mergeSameItemGroups(){
        List<ItemGroup> mergedList = new ArrayList<>();
        for (ItemGroup itemGroup : itemGroupList) {
            int index = mergedList.indexOf(itemGroup);
            if (index != -1) {
                mergedList.set(index, mergedList.get(index).merge(itemGroup));
            } else {
                mergedList.add(itemGroup);
            }
        }
        itemGroupList = mergedList;
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

    public double getTotalPrice() {
        return totalPrice;
    }
}
