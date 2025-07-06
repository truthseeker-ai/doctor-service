package com.hospital.doctorservice.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String specialization;
    private Integer yearsOfExperience;
}
