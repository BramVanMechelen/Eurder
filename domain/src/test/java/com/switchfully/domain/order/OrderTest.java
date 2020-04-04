package com.switchfully.domain.order;

import com.switchfully.domain.item.ItemGroup;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {


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
}