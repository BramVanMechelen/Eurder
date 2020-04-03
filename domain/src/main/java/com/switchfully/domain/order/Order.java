package com.switchfully.domain.order;

import com.switchfully.domain.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private int orderNumber;
    private List<ItemGroup> itemGroupList;
    private static int orderCounter = 0;

    public Order(List<ItemGroup> itemGroupList) {
        this.orderNumber = ++orderCounter;
        this.itemGroupList = itemGroupList;
    }

    public void mergeDuplicates(){
        List<ItemGroup> newItemGroupList = new ArrayList<>();

        for (ItemGroup itemGroup1: itemGroupList){
            for(ItemGroup itemGroup2: itemGroupList){
                if(itemGroup1.getItemName().equals(itemGroup2.getItemName())){
                    itemGroup1.setAmount(itemGroup1.getAmount() + itemGroup2.getAmount());

                }
            }
        }



        List<ItemGroup> list = itemGroupList;
        for (ItemGroup itemGroup1 : itemGroupList) {
            for (ItemGroup itemGroup2 : list) {
                if (itemGroup1.getItemName().equalsIgnoreCase(itemGroup2.getItemName()))  {
                    itemGroup2.setAmount(itemGroup1.getAmount() + itemGroup2.getAmount());
                    itemGroupList.remove(itemGroup1);
                }
            }
        }
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
