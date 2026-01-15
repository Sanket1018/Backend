package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.dto.CountBloodGroupResponseDTO;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.type.BloodGroup;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    // count patient by blood group
    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    // Group the patient according to the blood group
    // DTO projection
    @Query("select new com.hospital.hospitalproject.dto.CountBloodGroupResponseDTO( p.bloodGroup," + " Count(p))from Patient p GROUP BY p.bloodGroup")
    List<CountBloodGroupResponseDTO> findCountOfBloodGroup();


    // Native queries
    @Query(value = "select * from patient",nativeQuery = true)
    org.springframework.data.domain.Page<Patient> findAllPatients(Pageable pageable);


    // update query
    @Modifying
    @Query("update Patient p set p.name= :name Where p.id= :id")
    int updatedNameAndId(@Param("name") String name,@Param("id") Long id);

    // find the patients who has the appintments
    @Query("select p from Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN a.doctor")
    List<Patient> findAllAppointments();
}
