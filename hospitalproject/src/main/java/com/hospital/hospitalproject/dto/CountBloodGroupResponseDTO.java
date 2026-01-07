package com.hospital.hospitalproject.dto;

import com.hospital.hospitalproject.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountBloodGroupResponseDTO {
    private BloodGroup bloodGroup;
    private Long count;
}
