package com.hospital.doctorservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SlotDTO {
    private Long id;
    private Long doctorId;
    private LocalDate date;
    private String time;
    private Boolean available;
}
