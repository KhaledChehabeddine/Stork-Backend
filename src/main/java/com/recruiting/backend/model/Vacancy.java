package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Vacancy implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String country;
    private String city;
    private String jobDescription;
    private Date datePosted;
    private String workType;
    private String employmentType;

    public Vacancy () {}

    public Vacancy(Long id, String jobTitle, String country, String city, String jobDescription, Date datePosted,
                   String workType, String employmentType) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.country = country;
        this.city = city;
        this.jobDescription = jobDescription;
        this.datePosted = datePosted;
        this.workType = workType;
        this.employmentType = employmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    @Override
    public String toString() {
        return "Vacancy{id='" + id + "'" +
                ", title='" + jobTitle + "'" +
                ", country='" + country + "'" +
                ", city='" + city + "'" +
                ", description='" + jobDescription + "'" +
                ", datePosted='" + datePosted + "'" +
                "}";
    }
}
