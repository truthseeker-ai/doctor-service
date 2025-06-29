// Slot.java
package com.hospital.doctorservice.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity @Table(name="slots")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Slot {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private LocalDate date;
    private String time;      // e.g. "10:00-10:30"
    private Boolean available;
}
