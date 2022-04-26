package com.recruiting.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Action {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String title;

    public Action() { }

    public Action(Long id, Candidate candidate, Date date, String title) {
        this.id = id;
        this.candidate = candidate;
        this.date = date;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
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
                ", candidate='" + candidate + "'" +
                ", date='" + date + "'" +
                ", title='" + title + "'" +
                "}";
    }
}
