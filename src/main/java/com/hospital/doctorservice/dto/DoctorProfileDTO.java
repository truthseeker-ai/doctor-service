package com.hospital.doctorservice.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class DoctorProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String specialization;
    private Integer yearsOfExperience;
}
