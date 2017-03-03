package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.TPUser;
import com.travisperkins.jobmanager.model.UserInfo;

/**
 * Created by msamandi on 03/03/2017.
 */
public interface JobService {

     Job getJob(Long id) ;

     Item getItem(Long id) ;

     TPUser getTPUser(Long id);

     UserInfo getUserInfo(Long id);

     Job createJob(Job job) ;

     void deleteJob(Long id);

     Job updateJob(Long id, Job job);
}
