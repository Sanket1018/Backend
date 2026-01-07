package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.type.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    Patient findByName(String aaravSharma);

    Patient findByBirthDate(LocalDate birthDate);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

//    @Query("SELECT p from Patient p where p.bloodGroup = ? 1")
//    List<Patient> findByBloodGroup( @Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

}
