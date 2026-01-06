package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    Patient findByName(String aaravSharma);

    Patient findByBirthDate(LocalDate birthDate);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
}
