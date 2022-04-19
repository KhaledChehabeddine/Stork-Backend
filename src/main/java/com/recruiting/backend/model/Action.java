package com.recruiting.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Action {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long candidateId;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String title;

    public Action() { }

    public Action(Long id, Long candidateId, Date date, String title) {
        this.id = id;
        this.candidateId = candidateId;
        this.date = date;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Action{id='" + id + "'" +
                ", candidateId='" + candidateId + "'" +
                ", date='" + date + "'" +
                ", title='" + title + "'" +
                "}";
    }
}
