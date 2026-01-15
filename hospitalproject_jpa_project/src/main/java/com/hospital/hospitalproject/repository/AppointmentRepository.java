package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}