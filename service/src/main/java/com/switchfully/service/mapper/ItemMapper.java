package com.switchfully.service.mapper;

import com.switchfully.domain.item.Item;
import com.switchfully.service.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public static Item dtoToItem(ItemDto itemDto){
        return new Item(itemDto.getName(),itemDto.getDescription(),itemDto.getPrice(),itemDto.getAmount());
    }

    public static ItemDto itemToDto(Item item){
        return new ItemDto(item.getName(),item.getDescription(),item.getPrice(),item.getAmount());
    }


}
