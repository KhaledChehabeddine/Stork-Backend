package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Interview implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "vacancy_id")
    private Vacancy jobPosition;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manager_id")
    private Manager manager;
    @Column(nullable = false)
    private String dateTime;
    @Column(nullable = false)
    private String description;

    public Interview() { }

    public Interview(Long id, Candidate candidate, Vacancy jobPosition, Manager manager, String date_time, String description) {
        this.id = id;
        this.candidate = candidate;
        this.jobPosition = jobPosition;
        this.manager = manager;
        this.dateTime = date_time;
        this.description = description;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Vacancy getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(Vacancy jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getDateTime() { return dateTime; }

    public void setDateTime(String date_time) { this.dateTime = date_time; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Interview{id='" + id + "'" +
                ", candidate='" + candidate + "'" +
                ", jobPosition='" + jobPosition + "'" +
                ", date_time='" + dateTime + "'" +
                ", description='" + description + "'" +
                "}";
    }
}
