package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.*;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TPUserRepository tpUserRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = "job/{id}", method = RequestMethod.GET)
    public Job getJob(@PathVariable Long id) {
        return jobRepository.findOne(id);
    }

    @RequestMapping(value = "item/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable Long id) {
        return itemRepository.findOne(id);
    }

    @RequestMapping(value = "tpuser/{id}", method = RequestMethod.GET)
    public TPUser getTPUser(@PathVariable Long id) {
        return tpUserRepository.findOne(id);
    }

    @RequestMapping(value = "userinfo/{id}", method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable Long id) {
        return userInfoRepository.findOne(id);
    }

    @RequestMapping(value = "job", method = RequestMethod.POST)
    public Job createJob(@RequestBody Job job) {
        if(jobRepository.findOne(job.getId()) != null) {
            return updateJob(job.getId(), job);
        }
        return jobRepository.saveAndFlush(job);
    }

    @RequestMapping(value = "job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id) {
        jobRepository.delete(id);
    }

    @RequestMapping(value = "job/{id}", method = RequestMethod.PUT)
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        Job existing = jobRepository.findOne(id);
        List<Item> newItems = job.getJobSpecs().get(0).getItems();
        BeanUtils.copyProperties(job, existing);
        existing.getJobSpecs().get(0).setItems(newItems);
        return jobRepository.saveAndFlush(existing);
    }
}
