package com.hospital.doctorservice.controller;

import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors/{doctorId}/slots")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService svc;

    @GetMapping
    public List<SlotDTO> list(@PathVariable Long doctorId){
        return svc.list(doctorId)
                .stream()
                .map(SlotDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<SlotDTO> create(@PathVariable Long doctorId,
                                          @RequestBody SlotDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SlotDTO.fromEntity(svc.create(doctorId, dto)));
    }

    @PutMapping("/{slotId}")
    public ResponseEntity<SlotDTO> update(@PathVariable Long doctorId,
                                          @PathVariable Long slotId,
                                          @RequestBody SlotDTO dto){
        return ResponseEntity.ok(
                SlotDTO.fromEntity(svc.update(doctorId, slotId, dto)));
    }

    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> delete(@PathVariable Long doctorId,
                                       @PathVariable Long slotId){
        svc.delete(doctorId, slotId);
        return ResponseEntity.noContent().build();
    }
}
