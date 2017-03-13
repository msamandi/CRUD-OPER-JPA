package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Task;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.TaskRepository;
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
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable Long id) {
        return taskRepository.findOne(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public Task createTask(@PathVariable Long id, @RequestBody Task task) {
        if(taskRepository.findOne(id) != null) {
            return updateTask(task.getId(), task);
        }
        return taskRepository.saveAndFlush(task);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
    }

    //TODO: Completely Hacked
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existing = taskRepository.findOne(id);
        List<Item> newItems = task.getItems();
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

        task.setItems(newItemsWithJobSpec);
        BeanUtils.copyProperties(task, existing);
        return taskRepository.saveAndFlush(existing);
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
