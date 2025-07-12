package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAll() {
        log.debug("GET /api/doctors");
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        log.debug("GET /api/doctors/{}", id);
        return ResponseEntity.of(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor d) {
        log.debug("POST /api/doctors – {}", d);
        Doctor saved = doctorService.saveDoctor(d);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor d) {
        log.debug("PUT /api/doctors/{} – {}", id, d);
        d.setId(id);
        Doctor updated = doctorService.saveDoctor(d);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("DELETE /api/doctors/{}", id);
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}