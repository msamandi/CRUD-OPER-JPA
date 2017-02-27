package com.travisperkins.jobmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sverma on 27/02/2017.
 */
public class JobSpec {
    private int id;

    private List<Item> items;

    Date created;

    boolean isQuoteGenerated;

    Date quoteCreated;

    Date updated;
}
