// SlotDTO.java
package com.hospital.doctorservice.dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class SlotDTO {
    private LocalDate date;
    private String time;
    private Boolean available;
}