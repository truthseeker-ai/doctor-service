package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.dto.DoctorProfileDTO;
import com.hospital.doctorservice.dto.RegistrationRequest;
import com.hospital.doctorservice.dto.LoginRequest;
import com.hospital.doctorservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors/auth")
@RequiredArgsConstructor
public class AuthController {
    private final DoctorService svc;

    @PostMapping("/register")
    public ResponseEntity<DoctorProfileDTO> register(@RequestBody RegistrationRequest req) {
        return new ResponseEntity<>(svc.register(req), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<DoctorProfileDTO> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(svc.login(req));
    }
}