package com.travisperkins.jobmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@DiscriminatorValue(value = "TPContractor")
public class TPContractor extends TPUser {

}
