package com.hospital.hospitalproject.entity;

import com.hospital.hospitalproject.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(
        name ="Patient",
        uniqueConstraints = {
                @UniqueConstraint(name="unique-email-name",columnNames = "email"),
                @UniqueConstraint(name="unique-email-birthdate",columnNames = {"email","birthDate"})
        },
        indexes = {
                @Index(name="idx_patient_birth_date",columnList = "birthDate")
        }
        // unique constraint will just add the constraint to the table
        // index are used for faster search operations like in this example we set the index
        // on birthdate so whatever query that we create on the birthdate column they have faster execution
        // ,but it will increase a time of the insertion
)

public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="patient_name",nullable = false,length = 40)
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="patient_insurance_id")
    private Insurance insurance; // owning side

    @Column
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Appointment> appointments;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
