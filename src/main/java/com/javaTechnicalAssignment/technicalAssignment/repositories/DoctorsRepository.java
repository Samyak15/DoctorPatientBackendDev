package com.javaTechnicalAssignment.technicalAssignment.repositories;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DoctorsRepository extends JpaRepository<Doctors,Integer> {


    //Query to find doctor for a patient accoding to patient id and location and symptoms
    @Query(value = ("SELECT d.* FROM doctor d JOIN patient_doc pd ON d.id = pd.doc_id JOIN patient p ON pd.patientslist_id = p.id WHERE p.id = :patientId AND p.city = d.city"),nativeQuery = true)
    List<Doctors> findDoctorsByPatientId(@Param("patientId") Integer patientId);

    @Query(value = ("SELECT email FROM doctor d where d.email = :theemail"),nativeQuery = true)
    String findDoctorByEmail(@Param("theemail") String email);

}
