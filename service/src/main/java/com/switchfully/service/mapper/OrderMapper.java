package com.switchfully.service.mapper;

import com.switchfully.domain.order.Order;
import com.switchfully.service.dto.orderdto.CreateOrderDto;
import com.switchfully.service.dto.orderdto.ItemGroupDto;
import com.switchfully.service.dto.orderdto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
        List<ItemGroupDto> list = order.getItemGroupList().stream()
                .map(ItemGroupMapper::turnItemGroupInToItemGroupDto)
                .collect(Collectors.toList());
        return new OrderDto(order.getOrderNumber(), list, order.getTotalPrice());
    }
}
