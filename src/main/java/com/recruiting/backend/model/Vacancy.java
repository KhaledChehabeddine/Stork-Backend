package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

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

    public Vacancy () {}

    public Vacancy(Long id, String jobTitle, String country, String city, String jobDescription) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.country = country;
        this.city = city;
        this.jobDescription = jobDescription;
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

    @Override
    public String toString() {
        return "Vacancy{id='" + id + "'" +
                ", title='" + jobTitle + "'" +
                ", country='" + country + "'" +
                ", city='" + city + "'" +
                ", description='" + jobDescription + "'" +
                "}";
    }
}
