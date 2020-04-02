package com.switchfully.service.mapper;

import com.switchfully.domain.item.ItemGroup;
import com.switchfully.service.dto.CreateItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public static ItemGroup turnCreateItemGroupDtoInItemGroup(CreateItemGroupDto createItemGroupDto){
        return new ItemGroup(createItemGroupDto.getName(),createItemGroupDto.getAmount());
    }

}
