package com.hospital.hospitalproject.repository;

import com.hospital.hospitalproject.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}