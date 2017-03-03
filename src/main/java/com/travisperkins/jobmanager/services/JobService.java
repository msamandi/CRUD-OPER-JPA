package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.Item;
import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.TPUser;
import com.travisperkins.jobmanager.model.UserInfo;


import java.util.List;

/**
 * Created by msamandi on 03/03/2017.
 */
public interface JobService {

     Job getJobService(Long id) ;

     Item getItemService( Long id) ;

     TPUser getTPUserService(Long id);

     UserInfo getUserInfoService(Long id);

     Job createJobService(Job job) ;

     void deleteJobService(Long id);

     Job updateJobService(Long id,Job job);
}
