package com.hospital.doctorservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String time;

    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
