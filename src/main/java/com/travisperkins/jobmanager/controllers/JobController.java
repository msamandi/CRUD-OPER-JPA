package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.repository.JobRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "jobs/{id}", method = RequestMethod.GET)
    public Job getJob(@PathVariable Long id) {
        return jobRepository.getOne(id);
    }

    @RequestMapping(value = "job", method = RequestMethod.POST)
    public Job create(@RequestBody Job job) {
        if(jobRepository.findOne(job.getId()) != null) {
            return update(job.getId(), job);
        }
        return jobRepository.saveAndFlush(job);
    }

    @RequestMapping(value = "jobs/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        jobRepository.delete(id);
    }

    @RequestMapping(value = "jobs/{id}", method = RequestMethod.PUT)
    public Job update(@PathVariable Long id, @RequestBody Job job) {
        Job existing = jobRepository.findOne(id);
        BeanUtils.copyProperties(job, existing);
        return jobRepository.saveAndFlush(existing);
    }
}
