package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import com.javaTechnicalAssignment.technicalAssignment.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsServiceImpl implements DoctorsService{

    //defining field
    @Autowired
    private DoctorsRepository doctorsRepository;

    //constructor
    public DoctorsServiceImpl(DoctorsRepository doctorsRepository){
        this.doctorsRepository = doctorsRepository;
    }

    //methods
    @Override
    public void addNewDoctor(Doctors doc) throws Exception{

        try{
            //checking for duplicate entry
            if(doc.getDoctorEmail().equalsIgnoreCase(doctorsRepository.findDoctorByEmail(doc.getDoctorEmail()))) throw new Exception("\n Email already exists");
            doctorsRepository.save(doc);
        }
        catch(Exception e){
           throw new Exception(e.getMessage());
        }
    }

    public List<Doctors> suggestDoctors(Integer id) throws Exception {
        try {
            List<Doctors> doct = doctorsRepository.findDoctorsByPatientId(id);
            return doct;
        }
        catch (Exception e){
            throw new Exception("error occurred while suggesting Doctor");
        }

    }
}
