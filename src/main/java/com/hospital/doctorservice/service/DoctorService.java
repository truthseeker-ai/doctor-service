package com.hospital.doctorservice.service;

import com.hospital.doctorservice.dto.DoctorProfileDTO;
import com.hospital.doctorservice.dto.LoginRequest;
import com.hospital.doctorservice.dto.RegistrationRequest;
import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repo;

    public DoctorProfileDTO register(RegistrationRequest req) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(req.getFirstName());
        doctor.setLastName(req.getLastName());
        doctor.setEmail(req.getEmail());
        doctor.setPhone(req.getPhone());
        doctor.setSpecialization(req.getSpecialization());
        doctor.setYearsOfExperience(req.getYearsOfExperience());
        doctor.setPassword(req.getPassword());
        doctor = repo.save(doctor);
        return convertToDto(doctor);
    }

    public DoctorProfileDTO login(LoginRequest req) {
        Doctor doctor = repo.findByEmailAndPassword(req.getEmail(), req.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        return convertToDto(doctor);
    }

    public List<DoctorProfileDTO> getAllDoctors() {
        return repo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DoctorProfileDTO convertToDto(Doctor doctor) {
        return DoctorProfileDTO.builder()
                .id(doctor.getId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .specialization(doctor.getSpecialization())
                .yearsOfExperience(doctor.getYearsOfExperience())
                .build();
    }
}
