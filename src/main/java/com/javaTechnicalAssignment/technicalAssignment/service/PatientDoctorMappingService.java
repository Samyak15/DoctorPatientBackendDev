package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import com.javaTechnicalAssignment.technicalAssignment.repositories.DoctorsRepository;
import com.javaTechnicalAssignment.technicalAssignment.repositories.PatientsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDoctorMappingService implements PatientDoctorMappingSer {

    //defining filds
    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;

    //Constructor
    public  PatientDoctorMappingService(PatientsRepository patientsRepository,DoctorsRepository doctorsRepository){
        super();
        this.patientsRepository = patientsRepository;
        this.doctorsRepository = doctorsRepository;

    }
    public PatientDoctorMappingService() {

    }

    //Mapping patients to doctors method
    @Transactional
    public List<Doctors> mapPatientsToDoctors(Integer id,String symp) throws Exception{

        try{
            String symptop = symp;
            Patients p = new Patients();
            System.out.println("sympthom : "+ symp +"Id"+id);
            List<Doctors> ls = doctorsRepository.findAll();

            List<Doctors> lsdocs =new ArrayList<>();
            for(Doctors d: ls){
                System.out.println(d.getDoctorSpeciality());
                String docspeciality  = d.getDoctorSpeciality();
                if(docspeciality.equalsIgnoreCase(determineSpecialty(symptop))) {
                    System.out.println("inside loop"+"determine =  "+determineSpecialty(symptop));
                    lsdocs.add(d);
                    p = patientsRepository.findPatientById(id);
                    p.setDoc(lsdocs);
                    patientsRepository.save(p);
                }
            }
            return lsdocs;

        }
        catch (Exception e){
            throw new RuntimeException("Error while mapping patients to doctor");
        }

    }


    //method to determine speciality accoring to symptom
    private String determineSpecialty(String symptom) {
        // Add logic to determine the specialty based on symptoms
        if (List.of("Arthritis", "Back Pain", "Tissue injuries").contains(symptom)) {
            return "Orthopedic";
        } else if ("Dysmenorrhea".equals(symptom)) {
            return "Gynecology";
        } else if (List.of("Skin infection", "Skin burn").contains(symptom)) {
            return "Dermatology";
        } else if ("Ear pain".equals(symptom)) {
            return "ENT Specialist";
        } else {
            // Default or additional logic
            return "DefaultSpecialty";
        }

    }
}
