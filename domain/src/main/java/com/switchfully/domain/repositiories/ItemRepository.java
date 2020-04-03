package com.switchfully.domain.repositiories;


import com.switchfully.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ItemRepository {

    private Map<String, Item> itemRepositoryMap;


    @Autowired
    public ItemRepository() {
        this.itemRepositoryMap = new LinkedHashMap<>();
    }

    public Item addItem(Item item) {
        itemRepositoryMap.putIfAbsent(item.getName(), item);
        return itemRepositoryMap.get(item.getName());
    }

    public Map<String, Item> getItemMap() {
        return itemRepositoryMap;
    }

    public Item getItem(String itemName){
        return itemRepositoryMap.get(itemName);
    }

}
