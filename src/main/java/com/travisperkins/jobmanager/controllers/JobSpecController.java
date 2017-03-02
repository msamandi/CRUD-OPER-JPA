package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.JobSpec;
import com.travisperkins.jobmanager.repository.JobSpecRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by imunarriz on 23/02/2017.
 */

@RestController
@RequestMapping("api/v1/jobspec")
public class JobSpecController {

    @Autowired
    private JobSpecRepository jobSpecRepository;

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

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public JobSpec update(@PathVariable Long id, @RequestBody JobSpec job) {
        JobSpec existing = jobSpecRepository.findOne(id);
        BeanUtils.copyProperties(job, existing);
        return jobSpecRepository.saveAndFlush(existing);
    }
}
