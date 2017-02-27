package com.travisperkins.jobmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class Job {
    private int id;

    private List<JobSpec> jobSpecs;

    List<Invoice> invoices;

    Date created;

    TPContractor contractor;

    TPClient client;
}
