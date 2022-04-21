package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long candidateID;
    @Column(nullable = false)
    private Long managerID;
    @Column(nullable = false)
    private String notes;

    public Feedback() { }

    public Feedback(Long id, Long candidateID, Long managerID, String notes) {
        this.id = id;
        this.candidateID = candidateID;
        this.managerID = managerID;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(Long candidateID) {
        this.candidateID = candidateID;
    }

    public Long getManagerID() {
        return managerID;
    }

    public void setManagerID(Long managerID) {
        this.managerID = managerID;
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
                ", candidateID='" + candidateID + "'"+
                ", managerID='" + managerID + "'" +
                ", notes='" + notes + "'" +
                "}";
    }
}
