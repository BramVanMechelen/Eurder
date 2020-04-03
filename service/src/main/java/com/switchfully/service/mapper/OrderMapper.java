package com.switchfully.service.mapper;

import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import com.switchfully.service.dto.CreateOrderDto;
import com.switchfully.service.dto.ItemGroupDto;
import com.switchfully.service.dto.OrderDto;
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
        List<ItemGroupDto> list = new ArrayList<>();
        for (ItemGroup itemGroup : order.getItemGroupList()) {
            ItemGroupDto itemGroupDto = ItemGroupMapper.turnItemGroupInToItemGroupDto(itemGroup);
            list.add(itemGroupDto);
        }
        return new OrderDto(order.getOrderNumber(), list);
    }
}
