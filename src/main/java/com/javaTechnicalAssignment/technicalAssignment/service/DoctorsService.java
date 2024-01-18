package com.javaTechnicalAssignment.technicalAssignment.service;

import com.javaTechnicalAssignment.technicalAssignment.entities.Doctors;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public interface DoctorsService {

    void addNewDoctor(Doctors doc) throws Exception;

    List<Doctors> suggestDoctors(Integer id) throws Exception;

}
