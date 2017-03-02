package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.JobSpec;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobSpecRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1/jobspec")
public class JobSpecController {

    @Autowired
    private JobSpecRepository jobSpecRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public JobSpec getJobSpec(@PathVariable Long id) {
        return jobSpecRepository.findOne(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public JobSpec create(@PathVariable Long id, @RequestBody JobSpec jobSpec) {
        if(jobSpecRepository.findOne(id) != null) {
            return update(jobSpec.getId(), jobSpec);
        }
        return jobSpecRepository.saveAndFlush(jobSpec);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        jobSpecRepository.delete(id);
    }

    //TODO: Completely Hacked
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public JobSpec update(@PathVariable Long id, @RequestBody JobSpec jobSpec) {
        JobSpec existing = jobSpecRepository.findOne(id);
        List<Item> newItems = jobSpec.getItems();
        List<Item> originalItems = existing.getItems();
        List<Item> newItemsWithJobSpec = new ArrayList<>();

        for(Item item : newItems) {
            Item newItemFromRepo = itemRepository.findOne(item.getId());
            newItemFromRepo.setQuantity(item.getQuantity());
            newItemFromRepo.setPrice(item.getPrice());
            newItemsWithJobSpec.add(newItemFromRepo);
        }

        for(Item item : originalItems) {
            if(!itemExists(newItems, item)) {
                itemRepository.saveAndFlush(new Item(item));
            }
        }

        jobSpec.setItems(newItemsWithJobSpec);
        BeanUtils.copyProperties(jobSpec, existing);
        return jobSpecRepository.saveAndFlush(existing);
    }

    private boolean itemExists(List<Item> newItems, Item item) {
        for(Item item1 : newItems) {
            if(Objects.equals(item1.getId(), item.getId())) {
                return true;
            }
        }
        return false;
    }
}
