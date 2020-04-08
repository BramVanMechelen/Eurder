package com.switchfully.service;


import com.switchfully.domain.item.Item;
import com.switchfully.domain.repositiories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemService {


    public Item AddItemToRepo(Item item) {
        try {
            return ItemRepository.addItem(item);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return new Item(item.getName(), "Unknown item", 0, 0 );
        }
    }

    public Item GetItemFromRepo(String itemName){
        try {
            return ItemRepository.getItem(itemName);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            return new Item(itemName, "Unknwown item", 0,0);
        }
    }

    public Map<String, Item> getAllItemsFromRepo(){
        return ItemRepository.getItemsMap();
    }
}
