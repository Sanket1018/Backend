package com.hospital.hospitalproject.dto;

import com.hospital.hospitalproject.type.BloodGroup;

public class CountBloodGroupResponseDTO {

    private BloodGroup bloodGroup;
    private Long count;

    // ✅ THIS CONSTRUCTOR IS MANDATORY
    public CountBloodGroupResponseDTO(BloodGroup bloodGroup, Long count) {
        this.bloodGroup = bloodGroup;
        this.count = count;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "CountBloodGroupResponseDTO{" +
                "bloodGroup=" + bloodGroup +
                ", count=" + count +
                '}';
    }
}
