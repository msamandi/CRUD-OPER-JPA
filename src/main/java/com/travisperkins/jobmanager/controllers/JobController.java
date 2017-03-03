package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.TPUser;
import com.travisperkins.jobmanager.model.UserInfo;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import com.travisperkins.jobmanager.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1")
public class JobController {

    private JobService jobService;

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

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
        return jobService.getJob(id);
    }

    @RequestMapping(value = "item/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable Long id) {
        return jobService.getItem(id);
    }

    @RequestMapping(value = "tpuser/{id}", method = RequestMethod.GET)
    public TPUser getTPUser(@PathVariable Long id) {
        return jobService.getTPUser(id);
    }

    @RequestMapping(value = "userinfo/{id}", method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable Long id) {
        return jobService.getUserInfo(id);
    }

    @RequestMapping(value = "job", method = RequestMethod.POST)
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @RequestMapping(value = "job/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @RequestMapping(value = "job/{id}", method = RequestMethod.PUT)
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {

        return jobService.updateJob(id, job);
    }
}
