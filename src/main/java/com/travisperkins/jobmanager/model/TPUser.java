package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Table(name = "TPUSER")
public abstract class TPUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private UserType type;

    @Column(name = "USERINFO")
    private Long userInfo;

    public abstract UserType getType();

    public Long getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Long userInfo) {
        this.userInfo = userInfo;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TPUser{" +
                "id=" + id +
                ", type=" + type +
                ", userInfo=" + userInfo +
                '}';
    }
}
