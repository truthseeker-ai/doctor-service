package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.dto.DoctorProfileDTO;
import com.hospital.doctorservice.dto.LoginRequest;
import com.hospital.doctorservice.dto.RegistrationRequest;
import com.hospital.doctorservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors/auth")
@RequiredArgsConstructor
public class AuthController {

    private final DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<DoctorProfileDTO> register(@RequestBody RegistrationRequest req) {
        return ResponseEntity.ok(doctorService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<DoctorProfileDTO> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(doctorService.login(req));
    }
}
