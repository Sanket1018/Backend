package com.hospital.hospitalproject;

import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.repository.PatientRepository;
import com.hospital.hospitalproject.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class HospitalprojectApplicationTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

	@Test
    public void testPatientRepository()
    {
        List<Patient> patientList= patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        //patientRepository.save(p1); // patient saved into db

        // enitymanager internally calls persist
    }

    @Test
    public void  testTransansactionalsMethods()
    {
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        System.out.println(p1);
        System.out.println(p1);

        p1 = patientService.getPatientById(1L);
        System.out.println(p1);

        Patient patient = patientRepository.findByName("Aarav Sharma");
        System.out.println(patient);

        patientRepository.findByBirthDate(LocalDate.of(1988,3,15));

        List<Patient> patients = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"neha.iyer@example.com");

        for(Patient p:patients)
        {
            System.out.println(p);
        }





    }

}
