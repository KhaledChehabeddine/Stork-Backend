package com.recruiting.backend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
    @Id
    @Column(nullable = false)
    private Long id;
    private String firstName, lastName;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String jobTitle, String phone, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() { return this.firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + firstName + " " + lastName + "'" +
                ", email='" + email + "'" +
                ", jobTitle='" + jobTitle + "'" +
                ", phone='" + phone + "'" +
                ", imageUrl='" + imageUrl + "'" +
                "}";
    }
}

