package com.switchfully.domain.repositiories;

import com.switchfully.domain.customer.Customer;
import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {

    private final List<Order> orderList;

    @Autowired
    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}

