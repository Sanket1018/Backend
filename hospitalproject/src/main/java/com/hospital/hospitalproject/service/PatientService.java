package com.hospital.hospitalproject.service;

import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.repository.PatientRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id)
    {
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1==p2);

        // Dirty checking we are able to set the values into db directly
        p1.setName("Rohit");
        return p1;
    }


}
