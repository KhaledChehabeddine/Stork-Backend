package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Interview implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long candidateId;
    private Long vacancyId;
    private String dateTime;
    private String description;

    public Interview() { }

    public Interview(Long id, String candidate_id, String vacancy_id, String date_time, String description) {
        this.id = id;
        this.candidateId = Long.parseLong(candidate_id);
        this.vacancyId = Long.parseLong(vacancy_id);
        this.dateTime = date_time;
        this.description = description;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public Long getCandidateId() { return candidateId; }

    public void setCandidateId(Long candidate_id) { this.candidateId = candidate_id; }

    public Long getVacancyId() { return vacancyId; }

    public void setVacancyId(Long vacancy_id) { this.vacancyId = vacancy_id; }

    public String getDateTime() { return dateTime; }

    public void setDateTime(String date_time) { this.dateTime = date_time; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Interview{id='" + id + "'" +
                ", candidate_id='" + candidateId + "'" +
                ", vacancy_id='" + vacancyId + "'" +
                ", date_time='" + dateTime + "'" +
                ", description='" + description + "'" +
                "}";
    }
}
