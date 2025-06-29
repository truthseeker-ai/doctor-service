// SlotService.java
package com.hospital.doctorservice.service;
import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.entity.Slot;
import com.hospital.doctorservice.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class SlotService {
    private final SlotRepository repo;

    public List<SlotDTO> getSlots(Long doctorId) {
        return repo.findByDoctorIdAndAvailableTrue(doctorId)
                .stream()
                .map(s -> {
                    SlotDTO dto = new SlotDTO();
                    dto.setDate(s.getDate());
                    dto.setTime(s.getTime());
                    dto.setAvailable(s.getAvailable());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<SlotDTO> createSlots(Long doctorId, List<SlotDTO> slots) {
        List<Slot> entities = slots.stream().map(d ->
                Slot.builder()
                        .doctorId(doctorId)
                        .date(d.getDate())
                        .time(d.getTime())
                        .available(true)
                        .build()
        ).toList();
        repo.saveAll(entities);
        return getSlots(doctorId);
    }
}
