package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.entity.User;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.time.LocalDate;


public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findByDateAndUser(LocalDate date, User user);
    List<Schedule> findByUser(User user);
    @Query("SELECT s FROM Schedule s WHERE s.user = :user AND s.date >= :start AND s.date <= :end")
    List<Schedule> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}
