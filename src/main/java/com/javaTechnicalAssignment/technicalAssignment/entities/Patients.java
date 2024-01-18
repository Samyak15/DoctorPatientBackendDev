package com.javaTechnicalAssignment.technicalAssignment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patients {

    //Defining Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patient_name")
    private String patientName;

    @Valid
    @Size(max = 20, message = "City length must not exceed 20 characters")
    @Column(name = "city")
    private String patientCity;

    @Column(name = "email")
    @Valid
    @NotNull(message = "email is required")
    @Email(message = "Invalid Email")
    private String patientEmail;

    @Valid
    @Size(min = 10, message = "Phone number should contain at least 10 characters")
    @Column(name = "phone")
    private String patientPhoneNumber;


    //@NotNull
    @Column(name = "symptom")
    private String patientSymptom;

    @JsonIgnore
    @ManyToMany()
    private List<Doctors> doc;

    //Contructor
    public Patients() {

    }

    public Patients(String patientName, String patientCity, String patientEmail, String patientPhoneNumber, String patientSymptom) {
        this.patientName = patientName;
        this.patientCity = patientCity;
        this.patientEmail = patientEmail;
        this.patientPhoneNumber = patientPhoneNumber;
        this.patientSymptom = patientSymptom;
    }

    //getters and setters
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPatientSymptom() {
        return patientSymptom;
    }

    public void setPatientSymptom(String patientSymptom) {
        this.patientSymptom = patientSymptom;
    }

    public Integer getId() {
        return id;
    }

    public List<Doctors> getDoc() {
        return doc;
    }

    public void setDoc(List<Doctors> doc) {
        this.doc = doc;
    }

    //toString
    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientCity='" + patientCity + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientPhoneNumber='" + patientPhoneNumber + '\'' +
                ", patientSymptom='" + patientSymptom + '\'' +
                '}';
    }
}
