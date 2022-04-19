package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Candidate implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName, lastName;
    private String country;
    private String sex;
    private String phone;
    private Date date;
    private String status = "Pending";

    public Candidate() { }

    public Candidate(Long id, String firstName, String lastName, String email, String phone, String country, String sex,
                     Date date, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.country = country;
        this.sex = sex;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getSex() { return sex; }

    public void setSex() { this.sex = sex; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Candidate{id='" + id + "'" +
                ", name='" + firstName + " " + lastName + "'" +
                ", email='" + email + "'" +
                ", phone='" + phone + "'" +
                ", status='" + status + "'" +
                "}";
    }
}
