package com.switchfully.domain.order;

import com.switchfully.domain.item.ItemGroup;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {
/*

    @Test
    void IfItemGroupNameIsRepeated_MergeThemIntoOne(){
        ItemGroup itemGroup1 = new ItemGroup("apples", 5);
        ItemGroup itemGroup2 = new ItemGroup("apples", 2);
        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(itemGroup1);
        itemGroupList.add(itemGroup2);
        Order order = new Order(itemGroupList);
        order.mergeDuplicates();
       // assertEquals(1, order.getItemGroupList().size());
        assertEquals( 7, order.getItemGroupList().get(1).getAmount());
    }*/
}