package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Job;
import com.travisperkins.jobmanager.model.TPUser;
import com.travisperkins.jobmanager.model.UserInfo;
import com.travisperkins.jobmanager.services.JobService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sverma on 03/03/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class JobControllerTest {

    private static final Long TEST_ID = 290L;

    @InjectMocks
    private JobController jobController;

    @Mock
    private JobService jobServiceMock;

    @Before
    public void setup() {
        initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(jobServiceMock);
    }

    @Test
    public void testGetJob() {
        final Job job = new Job();
        //setup behaviour
        when(jobServiceMock.getJob(anyLong())).thenReturn(job);

        Job returned = jobController.getJob(TEST_ID);

        verify(jobServiceMock).getJob(TEST_ID);
        assertEquals(returned, job);
    }

    @Test
    public void testTPUser() {
        final TPUser tpUser = new TPUser();
        when(jobServiceMock.getTPUser(anyLong())).thenReturn(tpUser);

        jobController.getTPUser(TEST_ID);

        verify(jobServiceMock).getTPUser(TEST_ID);
    }

    @Test
    public void testUserInfo() {
        final UserInfo userInfo = new UserInfo();
        when(jobServiceMock.getUserInfo(anyLong())).thenReturn(userInfo);

        jobController.getUserInfo(TEST_ID);

        verify(jobServiceMock).getUserInfo(TEST_ID);
    }

    @Test
    public void testCreateJob() {
        Job job = new Job();
        job.setId(TEST_ID);
        when(jobServiceMock.createJob(isA(Job.class))).thenReturn(job);

        Job returned = jobController.createJob(job);

        verify(jobServiceMock).createJob(isA(Job.class));
        assertEquals(returned, job);
    }


    @Test
    public void testDeleteJob() {
        doNothing().when(jobServiceMock).deleteJob(anyLong());

        jobController.deleteJob(TEST_ID);

        verify(jobServiceMock).deleteJob(TEST_ID);
    }


    @Test
    public void testUpdateJob() {
        Job job = new Job();
        when(jobServiceMock.updateJob(anyLong(), isA(Job.class))).thenReturn(job);

        Job returned = jobController.updateJob(TEST_ID, job);

        verify(jobServiceMock).updateJob(anyLong(), isA(Job.class));
        assertEquals(returned, job);
    }


}
