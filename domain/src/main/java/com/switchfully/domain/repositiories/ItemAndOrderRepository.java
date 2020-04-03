package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.border.Border;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemAndOrderRepository {

    private Map<String, Item> itemRepositoryMap;
    private List<Order> orderList;

    @Autowired
    public ItemAndOrderRepository() {
        this.itemRepositoryMap = new LinkedHashMap<>();
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

    public Order updateShippingDates(Order order){
        for(ItemGroup itemGroup :order.getItemGroupList()){
            if (itemRepositoryMap.get(itemGroup.getItemName()).getAmount() < itemGroup.getAmount()){
                itemGroup.setShippingDate(LocalDate.now().plus(7, ChronoUnit.DAYS));
            } else {
                itemGroup.setShippingDate(LocalDate.now());
            }
        }
        return order;
    }

    public Order addOrder(Order order) {
        if (isItemInItemRepoMap(order)){
        //    order.mergeDuplicates();
            orderList.add(updateShippingDates(order));
            return updateShippingDates(order);
        }
        return null;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Map<String, Item> getItemMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName) {
        return itemRepositoryMap.get(itemName);
    }

}
