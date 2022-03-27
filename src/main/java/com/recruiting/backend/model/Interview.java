package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Interview implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long candidate_id;
    private Long vacancy_id;
    private String date_time;
    private String description;

    public Interview() { }

    public Interview(Long id, String candidate_id, String vacancy_id, String date_time, String description) {
        this.id = id;
        this.candidate_id = Long.parseLong(candidate_id);
        this.vacancy_id = Long.parseLong(vacancy_id);
        this.date_time = date_time;
        this.description = description;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public Long getCandidate_id() { return candidate_id; }

    public void setCandidate_id(Long candidate_id) { this.candidate_id = candidate_id; }

    public Long getVacancy_id() { return vacancy_id; }

    public void setVacancy_id(Long vacancy_id) { this.vacancy_id = vacancy_id; }

    public String getDate_time() { return date_time; }

    public void setDate_time(String date_time) { this.date_time = date_time; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Interview{id='" + id + "'" +
                ", candidate_id='" + candidate_id + "'" +
                ", vacancy_id='" + vacancy_id + "'" +
                ", date_time='" + date_time + "'" +
                ", description='" + description + "'" +
                "}";
    }
}
