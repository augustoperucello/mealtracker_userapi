package com.augusto.oauth2learning.Entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

//In this case, the entity can be thought as the DTO or the model.

@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)

public class User {

    //Here we are declaring the class attributes, with the necessary annotations to Hibernate understand that
    //Here we will have our own application unique ID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "first_name" , nullable = false)
    private String firstName;

    // This is an Facebook ID. Under registration, this variable will set the unique facebook ID from the user;
    @Column(name="facebook_id", nullable = false)
    private long facebookId;

    @Column(name= "last_name" , nullable = false)
    private String lastName;

    @Column(name="birthday", nullable = false)
    private Date birthday;

    @Column(name= "email_address" , nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name= "created_at" , nullable = false)
    private Date createdAt;

    @Column(name= "created_by" , nullable = false)
    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    @Column(name= "updated_at" , nullable = false)
    private Date updatedAt;

    @Column(name= "updated_by" , nullable = false)
    @LastModifiedBy
    private String updatedBy;
//Now we are going to the getters and setters

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



