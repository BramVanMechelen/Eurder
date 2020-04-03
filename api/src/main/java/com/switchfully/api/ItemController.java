package com.switchfully.api;

import com.switchfully.service.dto.ItemDto;
import com.switchfully.service.mapper.ItemMapper;
import com.switchfully.domain.repositiories.ItemAndOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = ItemController.ITEM_CONTROLLER_RESOURCE_URL)
public class ItemController {
    public static final String ITEM_CONTROLLER_RESOURCE_URL = "/item";

    private ItemAndOrderRepository itemAndOrderRepository;

    @Autowired
    public ItemController(ItemAndOrderRepository itemAndOrderRepository) {
        this.itemAndOrderRepository = itemAndOrderRepository;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(CREATED)
    public ItemDto addNewItem(@RequestBody ItemDto itemDto){
        return ItemMapper.itemToDto(itemAndOrderRepository.addItem(ItemMapper.dtoToItem(itemDto)));
    }
}
