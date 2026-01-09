package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}