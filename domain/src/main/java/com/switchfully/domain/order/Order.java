package com.switchfully.domain.order;

import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.repositiories.ItemRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            totalPrice += itemGroup.getPrice();
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

    public boolean isItemInItemRepoMap() {
        for (ItemGroup itemGroup : getItemGroupList()) {
            if (!ItemRepository.getItemsMap().containsKey(itemGroup.getItemName())) {
                return false;
            }
        }
        return true;
    }

    public void updateShippingDates(){
        for(ItemGroup itemGroup : getItemGroupList()){
            if (ItemRepository.getItemsMap().get(itemGroup.getItemName()).getAmount() < itemGroup.getAmount()){
                itemGroup.setShippingDate(LocalDate.now().plus(7, ChronoUnit.DAYS));
            } else {
                itemGroup.setShippingDate(LocalDate.now());
                itemGroup.removeFromStock();
            }
        }
    }
}
