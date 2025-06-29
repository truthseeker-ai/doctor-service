// AuthController.java
package com.hospital.doctorservice.controller;
import com.hospital.doctorservice.dto.*;
import com.hospital.doctorservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
