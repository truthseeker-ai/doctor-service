package com.hospital.doctorservice.service;

import com.hospital.doctorservice.dto.DoctorProfileDTO;
import com.hospital.doctorservice.dto.RegistrationRequest;
import com.hospital.doctorservice.dto.LoginRequest;
import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.repository.DoctorRepository;
import com.hospital.doctorservice.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repo;
    private final SlotRepository slotRepository;

    public DoctorProfileDTO register(RegistrationRequest req) {
        repo.findByEmail(req.getEmail())
                .ifPresent(d -> { throw new RuntimeException("Email already exists"); });

        Doctor doctor = Doctor.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(req.getPassword()) // Plain text
                .phone(req.getPhone())
                .specialization(req.getSpecialization())
                .yearsOfExperience(req.getYearsOfExperience())
                .build();

        Doctor saved = repo.save(doctor);
        return convertToDto(saved);
    }

    public DoctorProfileDTO login(LoginRequest req) {
        Doctor doctor = repo.findByEmailAndPassword(req.getEmail(), req.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        return convertToDto(doctor);
    }

    // ... other methods ...

    public void deleteDoctor(Long id) {
        Doctor doctor = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Delete all slots associated with this doctor
        slotRepository.deleteByDoctorId(doctor.getId());
        repo.delete(doctor);
    }

    private DoctorProfileDTO convertToDto(Doctor d) {
        return DoctorProfileDTO.builder()
                .id(d.getId())
                .firstName(d.getFirstName())
                .lastName(d.getLastName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .specialization(d.getSpecialization())
                .yearsOfExperience(d.getYearsOfExperience())
                .build();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repo.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return repo.findById(id);
    }

    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }
}