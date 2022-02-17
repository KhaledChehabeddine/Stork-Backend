package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
public class Candidate implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String imageUrl;
    private File resume;

    public Candidate() { }

    public Candidate(Long id, String name, String email, String phone, String imageUrl, File resume) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.resume = resume;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public File getResume() {
        return this.resume;
    }

    public void setResume(File resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "'" +
                ", name='" + name + "'" +
                ", email='" + email + "'" +
                ", phone='" + phone + "'" +
                ", imageUrl='" + imageUrl + "'" +
                "}";
    }

}
