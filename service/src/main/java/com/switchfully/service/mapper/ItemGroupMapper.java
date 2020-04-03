package com.switchfully.service.mapper;

import com.switchfully.domain.item.ItemGroup;
import com.switchfully.service.dto.CreateItemGroupDto;
import com.switchfully.service.dto.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public static ItemGroup turnCreateItemGroupDtoInItemGroup(CreateItemGroupDto createItemGroupDto){
        return new ItemGroup(createItemGroupDto.getName(),createItemGroupDto.getAmount());
    }

    public static ItemGroupDto turnItemGroupInToItemGroupDto(ItemGroup itemGroup){
        return new ItemGroupDto(itemGroup.getItemName(), itemGroup.getAmount(), itemGroup.getShippingDate().toString());
    }

}
