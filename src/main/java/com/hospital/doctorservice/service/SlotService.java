package com.hospital.doctorservice.service;

import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.entity.Slot;
import com.hospital.doctorservice.repository.DoctorRepository;
import com.hospital.doctorservice.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository repo;
    private final DoctorRepository doctorRepo;

    public List<SlotDTO> getSlots(Long doctorId) {
        return repo.findByDoctorId(doctorId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<SlotDTO> createSlots(Long doctorId, List<SlotDTO> slots) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        List<Slot> toSave = slots.stream()
                .map(dto -> {
                    Slot s = new Slot();
                    s.setDoctor(doctor);
                    s.setDate(dto.getDate());
                    s.setTime(dto.getTime());
                    s.setAvailable(true);
                    return s;
                })
                .collect(Collectors.toList());
        return repo.saveAll(toSave).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void deleteSlot(Long id) {
        repo.deleteById(id);
    }

    public List<SlotDTO> getAllSlots() {
        return repo.findAll().stream()
                .map(slot -> {
                    SlotDTO dto = new SlotDTO();
                    dto.setDoctorId(slot.getDoctor().getId());
                    dto.setDate(slot.getDate());
                    dto.setTime(slot.getTime());
                    dto.setAvailable(slot.getAvailable());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private SlotDTO toDto(Slot s) {
        SlotDTO dto = new SlotDTO();
        dto.setId(s.getId());
        dto.setDoctorId(s.getDoctor().getId());
        dto.setDate(s.getDate());
        dto.setTime(s.getTime());
        dto.setAvailable(s.getAvailable());
        return dto;
    }
}
