package com.switchfully.domain.order;

import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;

import com.switchfully.domain.repositiories.ItemRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {


    ItemRepository itemRepository = new ItemRepository();
    Item apple = new Item("Apple", "green and round",0.5, 10);
    ItemGroup itemGroupApples = new ItemGroup("Apple", 5);
    Item pear = new Item("Pear", "green and pearshaped",0.3, 10);
    ItemGroup itemGroupPears = new ItemGroup("Pear", 15);
    List<ItemGroup> itemGroupListWithApplesAndPears = new ArrayList<>();

    @Test
    void IfItemGroupNameIsRepeated_MergeThemIntoOne(){
        ItemGroup itemGroup1 = new ItemGroup("apples", 5);
        ItemGroup itemGroup2 = new ItemGroup("pears", 2);
        ItemGroup itemGroup3 = new ItemGroup("apples", 3);
        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(itemGroup1);
        itemGroupList.add(itemGroup2);
        itemGroupList.add(itemGroup3);
        Order order = new Order(itemGroupList);
        order.mergeSameItemGroups();
        assertEquals( 8, order.getItemGroupList().get(0).getAmount());
    }

    @Test
    void CheckIfShippingDateIsCorrect_ItemIsInStockItGetShippedToday(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemRepository.addItem(apple);
        Order orderOfApples = new Order(itemGroupListWithApplesAndPears);
        orderOfApples.updateShippingDates();
        int indexOfItemGroupApples = orderOfApples.getItemGroupList().indexOf(itemGroupApples);
        assertEquals(orderOfApples.getItemGroupList().get(indexOfItemGroupApples).getShippingDate(), LocalDate.now());
    }

    @Test
    void ChecKIfShippingDateIsCorrect_ItemIsNotInStockItGetShippedInAWeek(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemGroupListWithApplesAndPears.add(itemGroupPears);
        itemRepository.addItem(apple);
        itemRepository.addItem(pear);
        Order orderOfPears = new Order(itemGroupListWithApplesAndPears);
        orderOfPears.updateShippingDates();
        int indexOfItemGroupApples = orderOfPears.getItemGroupList().indexOf(itemGroupPears);
        assertEquals(orderOfPears.getItemGroupList().get(indexOfItemGroupApples).getShippingDate(), LocalDate.now().plus(7, ChronoUnit.DAYS));
    }

    @Test
    void CheckIfOrderedItemExistsInItemMap(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemRepository.addItem(apple);
        assertTrue(new Order(itemGroupListWithApplesAndPears).isItemInItemRepoMap());
    }
}