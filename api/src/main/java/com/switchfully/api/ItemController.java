package com.switchfully.api;

import com.switchfully.service.dto.ItemDto;
import com.switchfully.service.mapper.ItemMapper;
import com.switchfully.domain.repositiories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = ItemController.ITEM_CONTROLLER_RESOURCE_URL)
public class ItemController {
    public static final String ITEM_CONTROLLER_RESOURCE_URL = "/item";

    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(CREATED)
    public ItemDto addNewItem(@RequestBody ItemDto itemDto){
        return ItemMapper.itemToDto(itemRepository.addItem(ItemMapper.dtoToItem(itemDto)));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public List<ItemDto> getAllItems(){
        return ItemRepository.getItemsMap().values().stream().map(ItemMapper::itemToDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(ACCEPTED)
    public ItemDto getItemById(@PathVariable String id){
        return ItemMapper.itemToDto(itemRepository.getItem(id));
    }

}
