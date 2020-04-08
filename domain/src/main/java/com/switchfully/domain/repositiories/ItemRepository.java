package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemRepository {

    private static Map<String, Item> itemRepositoryMap = new LinkedHashMap<>();

    public static Item addItem(Item item) throws IllegalArgumentException {
        if (item.getName() == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public static Map<String, Item> getItemsMap() {
        return itemRepositoryMap;
    }

    public static Item getItem(String itemName) {
        if (itemRepositoryMap.containsKey(itemName)) {
            return itemRepositoryMap.get(itemName);
        } else {
            throw new IllegalArgumentException("Inventory does not contain item named: " + itemName);
        }
    }
}
