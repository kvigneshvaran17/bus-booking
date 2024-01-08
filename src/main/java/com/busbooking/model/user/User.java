package com.busbooking.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("loginId")
    private String loginId;
    @JsonProperty("password")
    private String password;
    @JsonProperty("userType")
    private UserType userType;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum<UserType> getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User(String loginId, UserType userType) {
        this.loginId = loginId;
        this.userType = userType;
    }

    public User(String loginId, String password, UserType userType) {
        this.loginId = loginId;
        this.password = password;
        this.userType = userType;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "loginId='" + loginId + '\'' +
                ", userType=" + userType +
                '}';
    }
}
