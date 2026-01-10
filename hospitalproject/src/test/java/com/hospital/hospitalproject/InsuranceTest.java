package com.hospital.hospitalproject;

import com.hospital.hospitalproject.entity.Appointment;
import com.hospital.hospitalproject.entity.Insurance;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.service.AppointmentService;
import com.hospital.hospitalproject.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,2L);
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
    }
}
