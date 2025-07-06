package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.dto.DoctorProfileDTO;
import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.service.DoctorService;
import com.hospital.doctorservice.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final SlotService slotService;

    @GetMapping
    public ResponseEntity<List<DoctorProfileDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/slotsAll")
    public ResponseEntity<List<SlotDTO>> getAllSlots() {
        return ResponseEntity.ok(slotService.getAllSlots());
    }
}
