package com.travisperkins.jobmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class Invoice {
    private int id;

    private int jobId;

    private List<JobSpec> jobSpecs;

    Date created;

    Price invoiceValue;
}
