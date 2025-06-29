package com.hospital.doctorservice.dto;
import lombok.Data;
@Data
public class RegistrationRequest {
    private String firstName, lastName, email, password, phone;
    private String specialization;
    private Integer yearsOfExperience;
    private String hospital;
}