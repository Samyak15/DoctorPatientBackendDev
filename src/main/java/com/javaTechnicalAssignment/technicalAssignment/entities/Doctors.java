package com.javaTechnicalAssignment.technicalAssignment.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctors {

    //defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Valid
    @Size(min = 3, message = "Name should contain at least 3 characters")
    @Column(name = "doctor_name")
    private String doctorName;

    @Valid
    @Size(max = 20, message = "City length must not exceed 20 characters")
    @Column(name = "city")
    private String doctorCity;

    @Column(name = "email")
    @Valid
    @NotNull(message = "email is required")
    @Email(message = "Invalid Email")
    private String doctorEmail;

    @Valid
    @Size(min = 10, message = "Phone number should contain at least 10 characters")
    @Column(name = "phone")
    private String doctorPhoneNumber;


    @NotNull
    @Column(name = "speciality")
    private String doctorSpeciality;


    @ManyToMany (mappedBy = "doc",cascade = CascadeType.ALL)
    private List<Patients> patientslist;

    //Constuctor
    public Doctors() {

    }

    public Doctors(String doctorName, String doctorCity, String doctorEmail, String doctorPhoneNumber, String doctorSpeciality){
        this.doctorName = doctorName;
        this.doctorCity = doctorCity;
        this.doctorEmail = doctorEmail;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.doctorSpeciality = doctorSpeciality;
    }

    //getters and setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorCity() {
        return doctorCity;
    }

    public void setDoctorCity(String doctorCity) {
        this.doctorCity = doctorCity;
    }
    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    public void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(String doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public Integer getId() {
        return id;
    }

    public void setPatientslist(List<Patients> patientslist) {
        this.patientslist = patientslist;
    }

    //toString
    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", doctorCity='" + doctorCity + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorPhoneNumber='" + doctorPhoneNumber + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                '}';
    }
}
