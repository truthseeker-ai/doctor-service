// DoctorService.java
package com.hospital.doctorservice.service;
import com.hospital.doctorservice.dto.*;
import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repo;

    public DoctorProfileDTO register(RegistrationRequest req) {
        Doctor d = Doctor.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(req.getPassword())
                .phone(req.getPhone())
                .specialization(req.getSpecialization())
                .yearsOfExperience(req.getYearsOfExperience())
                .hospital(req.getHospital())
                .build();
        Doctor saved = repo.save(d);
        return toDto(saved);
    }

    public DoctorProfileDTO login(LoginRequest req) {
        Doctor d = repo.findByEmailAndPassword(req.getEmail(), req.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        return toDto(d);
    }

    private DoctorProfileDTO toDto(Doctor d) {
        return DoctorProfileDTO.builder()
                .id(d.getId())
                .firstName(d.getFirstName())
                .lastName(d.getLastName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .specialization(d.getSpecialization())
                .yearsOfExperience(d.getYearsOfExperience())
                .hospital(d.getHospital())
                .build();
    }
}
