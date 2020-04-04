package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ItemRepository {

    private static Map<String, Item> itemRepositoryMap = new LinkedHashMap<>();

    public Item addItem(Item item) {
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public static Map<String, Item> getItemsMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName) {
        return itemRepositoryMap.get(itemName);
    }

}
