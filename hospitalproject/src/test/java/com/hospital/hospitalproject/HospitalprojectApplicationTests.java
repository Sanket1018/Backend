package com.hospital.hospitalproject;

import com.hospital.hospitalproject.dto.CountBloodGroupResponseDTO;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.repository.PatientRepository;
import com.hospital.hospitalproject.service.PatientService;
import com.hospital.hospitalproject.type.BloodGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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

        List<Patient> patientsList2 = patientRepository.findByBloodGroup(BloodGroup.A_NEGATIVE);

        for(Patient p:patientsList2)
        {
            System.out.println(p);
        }

        // find the count of patients by blood group

        List<CountBloodGroupResponseDTO> patientList3 = patientRepository.findCountOfBloodGroup();

        for(CountBloodGroupResponseDTO responseList: patientList3)
        {
            System.out.println(responseList);
        }

        // find all patients by native query
       Page<Patient> patientList4 = patientRepository.findAllPatients(PageRequest.of(1, 2,Sort.by("patient_name")));

        for(Patient p:patientList4)
        {
            System.out.println(p);
        }

        // update the patients
        int count = patientRepository.updatedNameAndId("Arav Sharma",1L);
        System.out.println(count+" rows affected");

        // returning blood group count response dto through query for specific returning data
        // Project dto
        List<CountBloodGroupResponseDTO> response = patientRepository.findCountOfBloodGroup();

        for(CountBloodGroupResponseDTO p:response)
        {
            System.out.println(response);
        }


    }

}
