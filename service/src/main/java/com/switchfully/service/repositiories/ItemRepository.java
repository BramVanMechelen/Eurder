package com.switchfully.service.repositiories;


import com.switchfully.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ItemRepository {

    private final Map<String, Item> itemMap;

    @Autowired
    public ItemRepository() {
        this.itemMap = new LinkedHashMap<>();
    }

    public Item addItem(Item item) {
        itemMap.putIfAbsent(item.getName(), item);
        return itemMap.get(item.getName());
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Item getItem(String itemName){
        return itemMap.get(itemName);
    }

}
