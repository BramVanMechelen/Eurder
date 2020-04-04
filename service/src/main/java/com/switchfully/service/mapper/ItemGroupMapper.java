package com.switchfully.service.mapper;

import com.switchfully.domain.item.ItemGroup;
import com.switchfully.service.dto.orderdto.CreateItemGroupDto;
import com.switchfully.service.dto.orderdto.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public static ItemGroup turnCreateItemGroupDtoInItemGroup(CreateItemGroupDto createItemGroupDto){
        return new ItemGroup(createItemGroupDto.getName(),createItemGroupDto.getAmount());
    }

    public static ItemGroupDto turnItemGroupInToItemGroupDto(ItemGroup itemGroup){
        return new ItemGroupDto(itemGroup.getItemName(), itemGroup.getAmount(), itemGroup.getShippingDate().toString(), itemGroup.getPrice());
    }
}
