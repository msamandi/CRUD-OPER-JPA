package com.travisperkins.jobmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
public abstract class TPUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userInfo;

    public abstract UserType getType();

    public Long getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Long userInfo) {
        this.userInfo = userInfo;
    }
}
