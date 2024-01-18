package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import org.springframework.stereotype.Service;

@Service
public interface PatientsService {

    void addNewPatient(Patients newpat) throws Exception;
}
