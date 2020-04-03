package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import com.switchfully.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemAndOrderRepository {

    private Map<String, Item> itemRepositoryMap;
    private final List<Order> orderList;

    @Autowired
    public ItemAndOrderRepository() {
        this.itemRepositoryMap = new LinkedHashMap<>();
        this.orderList = new ArrayList<>();
    }

    public Item addItem(Item item) {
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Map<String, Item> getItemMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName){
        return itemRepositoryMap.get(itemName);
    }

}
