package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import com.switchfully.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemAndOrderRepository {

    private static Map<String, Item> itemRepositoryMap = new LinkedHashMap<>();

    public Item addItem(Item item) {
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public Order addOrder(Order order) {
        if (order.isItemInItemRepoMap()){
            order.mergeSameItemGroups();
            OrderRepository.orderList.add(order.updateShippingDates(this));
            return order;
        }
        return null;
    }


    public List<Order> getOrderList() {
        return OrderRepository.orderList;
    }

    public static Map<String, Item> getItemsMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName) {
        return itemRepositoryMap.get(itemName);
    }

}
