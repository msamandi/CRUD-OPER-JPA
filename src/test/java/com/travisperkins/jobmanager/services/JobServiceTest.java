package com.travisperkins.jobmanager.services;

import com.travisperkins.jobmanager.model.*;
import com.travisperkins.jobmanager.repository.ItemRepository;
import com.travisperkins.jobmanager.repository.JobRepository;
import com.travisperkins.jobmanager.repository.TPUserRepository;
import com.travisperkins.jobmanager.repository.UserInfoRepository;
import com.travisperkins.jobmanager.representation.JobRepresentation;
import com.travisperkins.jobmanager.representation.TaskRepresentation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by sverma on 03/03/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class JobServiceTest {

    private static final Long TEST_ID = 290L;

    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobRepository jobRepositoryMock;

    @Mock
    private ItemRepository itemRepositoryMock;

    @Mock
    private TPUserRepository tpUserRepositoryMock;

    @Mock
    private UserInfoRepository userInfoRepositoryMock;

    @Before
    public void setup() {
        initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(jobRepositoryMock, itemRepositoryMock, tpUserRepositoryMock, userInfoRepositoryMock);
    }

    @Test
    public void testGetJob() {
        final Job job = new Job();
        final String name = "job_name";
        final String paymentTerms = "50% upfront";
        final int vat = 20;
        final TPContractor tpContractor = new TPContractor();
        final TPClient tpClient = new TPClient();
        final List<Task> taskList = new ArrayList<>();
        final List<TaskRepresentation> taskRepresentationList = new ArrayList<>();

        job.setId(TEST_ID);
        job.setName(name);
        job.setPaymentTerms(paymentTerms);
        job.setClient(tpClient);
        job.setContractor(tpContractor);
        job.setVat(vat);
        job.setTasks(taskList);

        final JobRepresentation jobRepresentation = new JobRepresentation
                .JobRepresentationBuilder(TEST_ID)
                .client(tpClient)
                .contractor(tpContractor)
                .name(name)
                .paymentTerms(paymentTerms)
                .vat(vat)
                .tasks(taskRepresentationList)
                .build();

        //setup behaviour
        when(jobRepositoryMock.findOne(anyLong())).thenReturn(job);

        JobRepresentation returned = jobService.getJob(TEST_ID);

        verify(jobRepositoryMock).findOne(TEST_ID);
        assertEquals(returned, jobRepresentation);
    }

    @Test
    public void testGetItem() {
        final Item item = new Item();
        when(itemRepositoryMock.findOne(anyLong())).thenReturn(item);

        Item returned = jobService.getItem(TEST_ID);

        verify(itemRepositoryMock).findOne(TEST_ID);
        assertEquals(returned, item);
    }

    @Test
    public void testTPUser() {
        final TPUser tpUser = new TPUser();
        when(tpUserRepositoryMock.findOne(anyLong())).thenReturn(tpUser);

        jobService.getTPUser(TEST_ID);

        verify(tpUserRepositoryMock).findOne(TEST_ID);
    }

    @Test
    public void testUserInfo() {
        final UserInfo userInfo = new UserInfo();
        when(userInfoRepositoryMock.findOne(anyLong())).thenReturn(userInfo);

        jobService.getUserInfo(TEST_ID);

        verify(userInfoRepositoryMock).findOne(TEST_ID);
    }

    @Test
    public void testCreateJob_JobDoesNotExists() {
        Job job = new Job();
        job.setId(TEST_ID);
        when(jobRepositoryMock.findOne(anyLong())).thenReturn(null);
        when(jobRepositoryMock.saveAndFlush(isA(Job.class))).thenReturn(job);

        Job returned = jobService.createJob(job);

        verify(jobRepositoryMock).findOne(TEST_ID);
        verify(jobRepositoryMock).saveAndFlush(isA(Job.class));
        assertEquals(returned, job);
    }

    @Test
    public void testCreateJob_JobExists() {
        Job job = setupUpdateMockData();

        Job returned = jobService.createJob(job);

        verify(jobRepositoryMock, times(2)).findOne(TEST_ID);
        verify(jobRepositoryMock).saveAndFlush(isA(Job.class));
        assertEquals(returned, job);
    }

    private Job setupUpdateMockData() {
        Job job = new Job();
        job.setId(TEST_ID);
        Task task = new Task();
        Item item = new Item();
        task.setItems(Collections.singletonList(item));
        job.setTasks(Collections.singletonList(task));
        when(jobRepositoryMock.findOne(anyLong())).thenReturn(job);
        when(jobRepositoryMock.saveAndFlush(isA(Job.class))).thenReturn(job);
        return job;
    }

    @Test
    public void testDeleteJob() {
        doNothing().when(jobRepositoryMock).delete(anyLong());

        jobService.deleteJob(TEST_ID);

        verify(jobRepositoryMock).delete(TEST_ID);
    }


    @Test
    public void testUpdateJob() {
        Job job = setupUpdateMockData();

        Job returned = jobService.updateJob(TEST_ID, job);

        verify(jobRepositoryMock, times(1)).findOne(TEST_ID);
        verify(jobRepositoryMock).saveAndFlush(isA(Job.class));
        assertEquals(returned, job);
    }


}
