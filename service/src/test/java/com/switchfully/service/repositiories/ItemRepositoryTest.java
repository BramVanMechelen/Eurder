package com.switchfully.service.repositiories;

import com.switchfully.domain.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();
    Item appel = new Item("Appel", "green and round", 0.5,10);

    @Test
    void addItemTest() {
        itemRepository.addItem(appel);
        assertEquals(itemRepository.getItem(appel.getName()), appel);
    }
}