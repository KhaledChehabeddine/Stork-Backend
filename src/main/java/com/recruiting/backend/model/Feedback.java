package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @Column(nullable = false)
    private String notes;

    public Feedback() { }

    public Feedback(Long id, Candidate candidate, Long managerID, String notes) {
        this.id = id;
        this.candidate = candidate;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Feedback{id='" + id + "'" +
                ", candidateID='" + candidate + "'"+
                ", notes='" + notes + "'" +
                "}";
    }
}
