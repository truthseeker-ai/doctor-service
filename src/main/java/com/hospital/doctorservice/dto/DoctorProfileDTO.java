// DoctorProfileDTO.java
package com.hospital.doctorservice.dto;
import lombok.Builder;
import lombok.Data;
@Data @Builder
public class DoctorProfileDTO {
    private Long id;
    private String firstName, lastName, email, phone;
    private String specialization;
    private Integer yearsOfExperience;
    private String hospital;
}