package com.augusto.oauth2learning.Entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public class User{
    @Id @GeneratedValue private long id;
    private String firstName;
    private long facebookId;
    private String lastName;
    private Date birthday;
    private String email;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public long getFacebookId()
    {
        return facebookId;
    }

    public void setFacebookId(Long facebookId)
    {
        this.facebookId = facebookId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(){
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}



