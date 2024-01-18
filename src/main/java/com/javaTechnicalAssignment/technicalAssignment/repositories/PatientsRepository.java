package com.javaTechnicalAssignment.technicalAssignment.repositories;

import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients,Integer> {

    //Query to find patient using patient id
    @Query("SELECT p FROM Patients p WHERE p.id = :patientId")
    Patients findPatientById(@Param("patientId") Integer patientId);

    @Query(value = ("SELECT email FROM patient p where p.email = :theemail"),nativeQuery = true)
    String findPatientByEmail(@Param("theemail") String email);

}
