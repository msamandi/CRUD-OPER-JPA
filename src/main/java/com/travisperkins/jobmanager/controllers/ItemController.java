package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.representation.ItemRepresentation;
import com.travisperkins.jobmanager.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@CrossOrigin(origins = "http://tp-job-manager-dev.andapps.co.uk:8081/")
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
