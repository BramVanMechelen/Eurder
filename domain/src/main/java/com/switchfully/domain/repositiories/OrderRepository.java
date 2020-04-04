package com.switchfully.domain.repositiories;

import com.switchfully.domain.order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    static List<Order> orderList = new ArrayList<>();

    public static Order addOrder(Order order) {
        if (order.isItemInItemRepoMap()){
            order.mergeSameItemGroups();
            order.updateShippingDates();
            OrderRepository.orderList.add(order);
            return order;
        }
        return null;
    }

    public static List<Order> getOrderList() {
        return OrderRepository.orderList;
    }
}
