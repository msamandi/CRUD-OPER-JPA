package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.*;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import com.travisperkins.jobmanager.services.ItemService;
import com.travisperkins.jobmanager.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1/item")
public class TagController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "{tag}", method = RequestMethod.GET)
    public List<Tag> getItems(@PathVariable String tag) {
        return itemService.getTag(tag);
    }

}
