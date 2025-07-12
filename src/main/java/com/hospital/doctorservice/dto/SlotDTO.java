package com.hospital.doctorservice.dto;

import com.hospital.doctorservice.entity.Slot;
import lombok.Data;
import java.time.LocalDate;

@Data
public class SlotDTO {
    private Long id;
    private LocalDate date;
    private String time;
    private Boolean available;

    public static SlotDTO fromEntity(Slot s){
        SlotDTO d = new SlotDTO();
        d.setId(s.getId());
        d.setDate(s.getDate());
        d.setTime(s.getTime());
        d.setAvailable(s.getAvailable());
        return d;
    }
}
