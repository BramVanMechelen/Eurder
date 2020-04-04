package com.switchfully.domain.repositiories;

import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemAndOrderRepositoryTest {

    ItemAndOrderRepository itemAndOrderRepository = new ItemAndOrderRepository();
    Item apple = new Item("Apple", "green and round",0.5, 10);
    ItemGroup itemGroupApples = new ItemGroup("Apple", 5);
    Item pear = new Item("Pear", "green and pearshaped",0.3, 10);
    ItemGroup itemGroupPears = new ItemGroup("Pear", 15);
    List<ItemGroup> itemGroupListWithApplesAndPears = new ArrayList<>();
    List<ItemGroup> itemGroupListWithoutApples = new ArrayList<>();

    @Test
    void CheckIfOrderedItemExistsInItemMap(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemAndOrderRepository.addItem(apple);
        assertTrue(new Order(itemGroupListWithApplesAndPears).isItemInItemRepoMap());
    }

    @Test
    void ChecKIfShippingDateIsCorrect_ItemIsInStockItGetShippedToday(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemAndOrderRepository.addItem(apple);
        Order orderOfApples = new Order(itemGroupListWithApplesAndPears);
        Order orderOfApplesWithCorrectShippingDate = orderOfApples.updateShippingDates(itemAndOrderRepository);
        int indexOfItemGroupApples = orderOfApples.getItemGroupList().indexOf(itemGroupApples);
        assertEquals(orderOfApplesWithCorrectShippingDate.getItemGroupList().get(indexOfItemGroupApples).getShippingDate(), LocalDate.now());
    }

    @Test
    void ChecKIfShippingDateIsCorrect_ItemIsNotInStockItGetShippedInAWeek(){
        itemGroupListWithApplesAndPears.add(itemGroupApples);
        itemGroupListWithApplesAndPears.add(itemGroupPears);
        itemAndOrderRepository.addItem(apple);
        itemAndOrderRepository.addItem(pear);
        Order orderOfPears = new Order(itemGroupListWithApplesAndPears);
        Order orderOfPearsWithCorrectShippingDate = orderOfPears.updateShippingDates(itemAndOrderRepository);
        int indexOfItemGroupApples = orderOfPears.getItemGroupList().indexOf(itemGroupPears);
        assertEquals(orderOfPearsWithCorrectShippingDate.getItemGroupList().get(indexOfItemGroupApples).getShippingDate(), LocalDate.now().plus(7, ChronoUnit.DAYS));
    }

}