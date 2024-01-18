package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientDoctorMappingSer {
    List<Doctors> mapPatientsToDoctors(Integer id, String symp) throws Exception;
}
