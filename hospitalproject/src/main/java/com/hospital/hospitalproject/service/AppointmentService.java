package com.hospital.hospitalproject.service;

import com.hospital.hospitalproject.entity.Appointment;
import com.hospital.hospitalproject.entity.Doctor;
import com.hospital.hospitalproject.entity.Patient;
import com.hospital.hospitalproject.repository.AppointmentRepository;
import com.hospital.hospitalproject.repository.DoctorRepository;
import com.hospital.hospitalproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppointmentService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createNewAppointment(Long patientId,Long doctorId,Appointment appointment)
    {
        // create a new appointment
        // for the creating appointment we required patient and doctors
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow((()-> new RuntimeException("Doctor not found")));

        if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment should have ID");

        // always owning side can set and it will do dirty checking
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointment(Long appintmentId,Long doctorId)
    {
        Appointment appointment = appointmentRepository.findById(appintmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        // we want to set a reappointment
        appointment.setDoctor(doctor);

        // And always check and maintain bidirectional consistency
        doctor.getAppointments

                ().add(appointment);

        return appointment;
    }

}
