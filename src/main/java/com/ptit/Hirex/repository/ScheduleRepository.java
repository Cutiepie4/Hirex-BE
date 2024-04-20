package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.Schedule;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findByDate(LocalDate date);
}
