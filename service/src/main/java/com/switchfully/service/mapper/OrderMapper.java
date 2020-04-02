package com.switchfully.service.mapper;

import com.switchfully.domain.item.Item;
import com.switchfully.domain.item.ItemGroup;
import com.switchfully.domain.order.Order;
import com.switchfully.service.dto.CreateOrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static Order turnCreateOrderDtoInOrder(CreateOrderDto createOrderDto){
        List<ItemGroup> itemGroupList = createOrderDto.getItemGroupList()
                .stream()
                .map(ItemGroupMapper::turnCreateItemGroupDtoInItemGroup)
                .collect(Collectors.toCollection(ArrayList::new));
        return new Order(itemGroupList);
    }
}
