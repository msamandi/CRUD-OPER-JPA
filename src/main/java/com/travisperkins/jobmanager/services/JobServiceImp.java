package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.TPUser;
import com.travisperkins.jobmanager.model.UserInfo;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by msamandi on 03/03/2017.
 */
@Service
public class JobServiceImp implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TPUserRepository tpUserRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public Job getJobService(Long id) {
        return jobRepository.findOne(id);
    }

    @Override
    public Item getItemService(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public TPUser getTPUserService(Long id) {
        return tpUserRepository.findOne(id);
    }

    @Override
    public UserInfo getUserInfoService(Long id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public Job createJobService(Job job) {
        if(jobRepository.findOne(job.getId()) != null) {
            return updateJobService(job.getId(), job);
        }
        return jobRepository.saveAndFlush(job);    }

    @Override
    public void deleteJobService(Long id) {
        jobRepository.delete(id);

    }

    @Override
    public Job updateJobService(Long id,Job job) {
        Job existing = jobRepository.findOne(id);
        List<Item> newItems = job.getJobSpecs().get(0).getItems();
        BeanUtils.copyProperties(job, existing);
        existing.getJobSpecs().get(0).setItems(newItems);
        return jobRepository.saveAndFlush(existing);     }
}







