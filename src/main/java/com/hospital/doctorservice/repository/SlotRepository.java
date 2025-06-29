// SlotRepository.java
package com.hospital.doctorservice.repository;
import com.hospital.doctorservice.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByDoctorIdAndAvailableTrue(Long doctorId);
}