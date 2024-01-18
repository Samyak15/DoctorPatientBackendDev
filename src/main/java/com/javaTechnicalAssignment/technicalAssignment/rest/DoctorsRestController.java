package com.javaTechnicalAssignment.technicalAssignment.rest;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import com.javaTechnicalAssignment.technicalAssignment.models.PatientInput;
import com.javaTechnicalAssignment.technicalAssignment.repositories.PatientsRepository;
import com.javaTechnicalAssignment.technicalAssignment.service.DoctorsServiceImpl;
import com.javaTechnicalAssignment.technicalAssignment.service.PatientDoctorMappingService;
import jakarta.validation.Valid;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorsRestController {

    //defining field
    @Autowired
    private DoctorsServiceImpl doctorsServiceImpl;

    @Autowired
    private PatientDoctorMappingService patientDoctorMappingService;

    @Autowired
    private PatientsRepository patientsRepository;

    //Constructor
    public DoctorsRestController(DoctorsServiceImpl doctorsService, PatientDoctorMappingService patientDoctorMappingService){
        this.doctorsServiceImpl = doctorsService;
        this.patientDoctorMappingService = patientDoctorMappingService;
    }


    //endpoints

    //api endpoint for adding a doctor
    @PostMapping("/adddoctor")
    public ResponseEntity<String> addNewDoctor(@Valid @RequestBody Doctors newdoc, BindingResult bindingResult) throws Exception{
        try{
            if (bindingResult.hasErrors()) {
                // Handle validation errors
                return new ResponseEntity<>("Validation error: " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
            System.out.println("Request to add new doctor"+newdoc);
            doctorsServiceImpl.addNewDoctor(newdoc);
            System.out.println("Successfully added the doctor");
            return new ResponseEntity<>("Successfully added the doctor", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("An error occurred while adding a doctor"+ e);
            return new ResponseEntity<>("error occurred in adding the doctor"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

     //api suggest the doctor endpoint
    @GetMapping("/suggestdoctor")
    public ResponseEntity<Object> suggestionForDoctors(@Valid @RequestBody PatientInput patientInput,BindingResult bindingResult) throws Exception{
        try{

            if (bindingResult.hasErrors()) {
                // Handle validation errors
                throw  new Exception("Validation error " + bindingResult.getFieldError().getDefaultMessage());
            }

            List<Doctors> checklist = patientDoctorMappingService.mapPatientsToDoctors(patientInput.getId(), patientInput.getSymp());

            Patients p = new Patients();

            p = patientsRepository.findPatientById(patientInput.getId());

            List<Doctors> result = doctorsServiceImpl.suggestDoctors(patientInput.getId());
            System.out.println(result.size());
            System.out.println(p.getPatientCity());


            //Handling edge cases

            //Case 1 : when there is no doctor on that location
            if((!p.getPatientCity().equalsIgnoreCase("Noida")&&!p.getPatientCity().equalsIgnoreCase("Delhi")&&!p.getPatientCity().equalsIgnoreCase("Faridabad"))&& result.isEmpty()){
                throw new Exception("We are still waiting to expand to your location");
            }

            //Case 2 : when there is no doctor present at the patients location according to their symptom
            else if(result.isEmpty() && checklist.isEmpty()){
                throw new Exception("There isn’t any doctor present at your location for your symptom");
            }

            return new ResponseEntity<>(result,new HttpHeaders(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }


}
