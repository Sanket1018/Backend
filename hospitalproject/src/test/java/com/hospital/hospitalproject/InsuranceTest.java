package com.hospital.hospitalproject;

import com.hospital.hospitalproject.entity.Appointment;
import com.hospital.hospitalproject.entity.Insurance;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.service.AppointmentService;
import com.hospital.hospitalproject.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance()
    {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient = insuranceService.disaccosicateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment()
    {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,30))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createNewAppointment(1L,1L,appointment);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reassignAppointment(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);
    }




}
