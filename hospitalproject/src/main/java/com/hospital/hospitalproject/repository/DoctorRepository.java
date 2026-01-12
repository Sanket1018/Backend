package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Appointment;
import com.hospital.hospitalproject.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}