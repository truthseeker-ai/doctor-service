package com.hospital.doctorservice.repository;

import com.hospital.doctorservice.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    /**
     * Finds all slots for a given doctor.
     * @param doctorId the ID of the doctor
     * @return a list of slots
     */
    List<Slot> findByDoctorId(Long doctorId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Slot s WHERE s.doctorId = :doctorId")
    void deleteByDoctorId(Long doctorId);
}