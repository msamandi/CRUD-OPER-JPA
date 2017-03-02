package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@DiscriminatorValue(value = "TPClient")
public class TPClient extends TPUser {


}
