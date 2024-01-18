package com.javaTechnicalAssignment.technicalAssignment.rest;

import com.javaTechnicalAssignment.technicalAssignment.entities.Patients;
import com.javaTechnicalAssignment.technicalAssignment.service.PatientsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientsRestController{

    //defining fields
    private PatientsServiceImpl patientsService;

    //constructor
    public PatientsRestController(PatientsServiceImpl patientsService){
        this.patientsService = patientsService;
    }

    //endpoints

    //api endpoint for adding a patient
    @PostMapping("/addpatient")
    public ResponseEntity<String> addnewPatient(@Valid @RequestBody Patients pat, BindingResult bindingResult) throws Exception {
        try {
            if(bindingResult.hasErrors()){
                // Handle validation errors
                return new ResponseEntity<>("Validation error: " + bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
            }
            System.out.println("Received request to add a new patient: "+ pat);
            patientsService.addNewPatient(pat);
            System.out.println("Successfully added the patient");
            return new ResponseEntity<>("Successfully added the patient", HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("An error occurred while adding a patient"+ e);
            return new ResponseEntity<>("An error occurred: Cannot add a patient " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
