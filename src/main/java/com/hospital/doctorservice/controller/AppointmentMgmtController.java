package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.dto.AppointmentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class AppointmentMgmtController {
    private final RestTemplate rest;
    @Value("${appointment.service.url}") private String apptUrl;

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<List<AppointmentResponseDTO>> list(
            @PathVariable Long doctorId) {
        List<AppointmentResponseDTO> list = rest.exchange(
                        apptUrl + "/api/appointments/doctor/" + doctorId,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<AppointmentResponseDTO>>() {})
                .getBody();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/appointments/{appointmentId}/status")
    public ResponseEntity<AppointmentResponseDTO> updateStatus(
            @PathVariable Long appointmentId,
            @RequestParam String status) {
        AppointmentResponseDTO dto = rest.exchange(
                apptUrl + "/api/appointments/" + appointmentId + "/status?status=" + status,
                HttpMethod.PUT, null, AppointmentResponseDTO.class
        ).getBody();
        return ResponseEntity.ok(dto);
    }
}
