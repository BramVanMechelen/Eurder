package com.switchfully.api;

import com.switchfully.service.repositiories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = CustomerController.CUSTOMER_CONTROLLER_RESOURCE_URL)
public class ItemController {
    public static final String CUSTOMER_CONTROLLER_RESOURCE_URL = "/item";

    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
