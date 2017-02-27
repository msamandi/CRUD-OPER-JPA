package com.travisperkins.jobmanager.model;

/**
 * Created by sverma on 27/02/2017.
 */
public class TPClient extends TPUser {

    @Override
    public UserType getType() {
        return UserType.USER_TYPE_CLIENT;
    }
}
