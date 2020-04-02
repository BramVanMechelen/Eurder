package com.switchfully.service.mapper;

import com.switchfully.domain.order.Order;
import com.switchfully.service.dto.CreateOrderDto;
import com.switchfully.service.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static Order turnCreateOrderDtoInOrder(CreateOrderDto createOrderDto) {
        return new Order(createOrderDto.getItemGroupList()
                .stream()
                .map(ItemGroupMapper::turnCreateItemGroupDtoInItemGroup)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static OrderDto turnOrderInOrderDto(Order order) {
        return new OrderDto(order.getOrderNumber(),
                order.getItemGroupList()
                        .stream()
                        .map(ItemGroupMapper::turnItemGroupInToCreateItemGroupDto)
                        .collect(Collectors.toList()));
    }
}
