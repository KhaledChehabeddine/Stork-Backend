package com.recruiting.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Manager implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String countryPhone;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String gender;

    public Manager() { }

    public Manager(Long id, String firstName, String lastName, String email, String countryPhone,
                   String phone, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.countryPhone = countryPhone;
        this.phone = phone;
        this.gender = gender;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryPhone() { return this.countryPhone; }

    public void setCountryPhone(String countryPhone) { this.countryPhone = countryPhone; }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Manager {" +
                "   id: " + id + "," +
                "   name: " + firstName + " " + lastName + "," +
                "   email: " + email + "," +
                "   phone:" + phone + "," +
                "   gender:" + gender +
                "}";
    }
}
