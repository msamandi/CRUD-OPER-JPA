package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.*;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import com.travisperkins.jobmanager.representation.JobRepresentation;
import com.travisperkins.jobmanager.representation.TaskRepresentation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msamandi on 03/03/2017.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TPUserRepository tpUserRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public JobRepresentation getJob(Long id) {
        Job job = jobRepository.findOne(id);

        return mapToJobRepresentation(job);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public TPUser getTPUser(Long id) {
        return tpUserRepository.findOne(id);
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public Job createJob(Job job) {
        if (jobRepository.findOne(job.getId()) != null) {
            return updateJob(job.getId(), job);
        }
        return jobRepository.saveAndFlush(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.delete(id);

    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job existing = jobRepository.findOne(id);
        List<Item> newItems = job.getTasks().get(0).getItems();
        BeanUtils.copyProperties(job, existing);
        existing.getTasks().get(0).setItems(newItems);
        return jobRepository.saveAndFlush(existing);
    }

    private JobRepresentation mapToJobRepresentation(Job job) {
        return new JobRepresentation.JobRepresentationBuilder(job.getId())
                .client(job.getClient())
                .contractor(job.getContractor())
                .created(job.getCreated())
                .name(job.getName())
                .paymentTerms(job.getPaymentTerms())
                .vat(job.getVat())
                .tasks(mapToTaskRepresentation(job.getTasks()))
                .build();
    }

    private List<TaskRepresentation> mapToTaskRepresentation(List<Task> tasks) {
        List<TaskRepresentation> taskRepresentations = new ArrayList<>();
        if(tasks == null) {
            return null;
        }
        for(Task task: tasks) {
            TaskRepresentation taskRepresentation = new TaskRepresentation
                    .TaskRepresentationBuilder(task.getId())
                    .created(task.getCreated())
                    .updated(task.getUpdated())
                    .name(task.getName())
                    .job(task.getJob())
                    .build();
            taskRepresentations.add(taskRepresentation);
        }
        return taskRepresentations;
    }

}







