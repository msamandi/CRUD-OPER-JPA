package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.representation.ItemRepresentation;
import com.travisperkins.jobmanager.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "{tag}", method = RequestMethod.GET)
    public List<ItemRepresentation> getItems(@PathVariable String tag) {
        return itemService.getItems(tag);
    }

}
