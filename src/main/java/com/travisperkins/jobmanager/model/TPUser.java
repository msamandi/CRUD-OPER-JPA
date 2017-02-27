package com.travisperkins.jobmanager.model;

/**
 * Created by sverma on 27/02/2017.
 */
public abstract class TPUser {

    private UserInfo userInfo;

    public abstract UserType getType();

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
