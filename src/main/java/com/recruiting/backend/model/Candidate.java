package com.recruiting.backend.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Transactional
public class Candidate implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String status = "Pending";
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "vacancy_id", nullable = false)
    Vacancy jobPosition;

    public Candidate() { }

    public Candidate(Long id, String firstName, String lastName, String email, String phone, String country, String sex,
                     Date date, String status, Vacancy jobPosition) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.country = country;
        this.sex = sex;
        this.status = status;
        this.jobPosition = jobPosition;
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

    public Vacancy getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(Vacancy jobPosition) {
        this.jobPosition = jobPosition;
    }

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
