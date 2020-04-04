package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemAndOrderRepository {

    private static Map<String, Item> itemRepositoryMap = new LinkedHashMap<>();
    private List<Order> orderList;

    @Autowired
    public ItemAndOrderRepository() {
        this.orderList = new ArrayList<>();
    }

    public Item addItem(Item item) {
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public boolean isItemInItemRepoMap(Order order) {
        for (ItemGroup itemGroup : order.getItemGroupList()) {
            if (!itemRepositoryMap.containsKey(itemGroup.getItemName())) {
                return false;
            }
        }
        return true;
    }

    public Order addOrder(Order order) {
        if (isItemInItemRepoMap(order)){
            order.mergeSameItemGroups();
            orderList.add(updateShippingDates(order));
            return order;
        }
        return null;
    }



    public Order updateShippingDates(Order order){
        for(ItemGroup itemGroup :order.getItemGroupList()){
            if (itemRepositoryMap.get(itemGroup.getItemName()).getAmount() < itemGroup.getAmount()){
                itemGroup.setShippingDate(LocalDate.now().plus(7, ChronoUnit.DAYS));
            } else {
                itemGroup.setShippingDate(LocalDate.now());
                removeFromStock(itemGroup);
            }
        }
        return order;
    }

    public void removeFromStock(ItemGroup itemGroup){
        itemRepositoryMap.get(itemGroup.getItemName()).setAmount(itemRepositoryMap.get(itemGroup.getItemName()).getAmount() - itemGroup.getAmount());
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public static Map<String, Item> getItemMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName) {
        return itemRepositoryMap.get(itemName);
    }

}
