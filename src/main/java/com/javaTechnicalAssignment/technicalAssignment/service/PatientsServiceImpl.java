package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import com.javaTechnicalAssignment.technicalAssignment.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientsServiceImpl implements PatientsService{

    //defining fields
    @Autowired
    private PatientsRepository patientsRepository;

    //constructor
    @Autowired
    public PatientsServiceImpl(PatientsRepository patientsRepository){
        this.patientsRepository = patientsRepository;
    }

    //methods

    //method to add a new patient in our database
    @Override
    public void addNewPatient(Patients newpat) throws Exception {

        try{

            //checking for duplicate entry
            if(newpat.getPatientEmail().equalsIgnoreCase(patientsRepository.findPatientByEmail(newpat.getPatientEmail()))) throw new Exception(" \n Email already exists");

            patientsRepository.save(newpat);
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

}
