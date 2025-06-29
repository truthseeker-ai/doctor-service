// SlotController.java
package com.hospital.doctorservice.controller;
import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class SlotController {
    private final SlotService svc;

    @GetMapping("/{doctorId}/slots")
    public ResponseEntity<List<SlotDTO>> listSlots(@PathVariable Long doctorId) {
        return ResponseEntity.ok(svc.getSlots(doctorId));
    }

    @PostMapping("/{doctorId}/slots")
    public ResponseEntity<List<SlotDTO>> createSlots(
            @PathVariable Long doctorId,
            @RequestBody List<SlotDTO> slots) {
        return new ResponseEntity<>(svc.createSlots(doctorId, slots), HttpStatus.CREATED);
    }
}
