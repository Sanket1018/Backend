package com.hospital.hospitalproject.service;

import com.hospital.hospitalproject.entity.Insurance;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.repository.InsuranceRepository;
import com.hospital.hospitalproject.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;


    // assigning insurance to patient
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId)
    {
        // First we need the patient
        Patient patient =  patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found"));

        // now we have to set the insurance to patient
        // setting at the transient level
        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bi directional consistency

        return patient;
    }

}
