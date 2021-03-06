package com.travisperkins.jobmanager.model;

import javax.persistence.*;

/**
 * Created by sverma on 27/02/2017.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name = "TPUSER")
public class TPUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="USERINFO_ID", unique= true)
    private UserInfo userInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    @Override
    public String toString() {
        return "TPUser{" +
                "id=" + id +
                ", userInfo=" + userInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPUser tpUser = (TPUser) o;

        if (id != null ? !id.equals(tpUser.id) : tpUser.id != null) return false;
        return userInfo != null ? userInfo.equals(tpUser.userInfo) : tpUser.userInfo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userInfo != null ? userInfo.hashCode() : 0);
        return result;
    }
}
