package com.hospital.doctorservice.service;

import com.hospital.doctorservice.dto.SlotDTO;
import com.hospital.doctorservice.entity.Slot;
import com.hospital.doctorservice.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository repo;

    public List<Slot> list(Long doctorId){
        return repo.findByDoctorId(doctorId);
    }

    public Slot create(Long doctorId, SlotDTO dto){
        Slot s = Slot.builder()
                .doctorId(doctorId)
                .date(dto.getDate())
                .time(dto.getTime())
                .available(true)
                .build();
        return repo.save(s);
    }

    public Slot update(Long doctorId, Long slotId, SlotDTO dto){
        Slot s = repo.findById(slotId)
                .filter(sl -> sl.getDoctorId().equals(doctorId))
                .orElseThrow();
        s.setDate(dto.getDate());
        s.setTime(dto.getTime());
        s.setAvailable(dto.getAvailable());
        return repo.save(s);
    }

    public void delete(Long doctorId, Long slotId){
        repo.findById(slotId)
                .filter(sl -> sl.getDoctorId().equals(doctorId))
                .ifPresent(repo::delete);
    }
}
