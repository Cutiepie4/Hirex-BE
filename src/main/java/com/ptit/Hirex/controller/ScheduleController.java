package com.ptit.Hirex.controller;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.responses.ScheduleResponse;
import com.ptit.Hirex.service.impl.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ScheduleController {
    private final ScheduleServiceImpl scheduleServiceImpl;

    @GetMapping("/schedules_by_user/{phoneNumber}/{dateStart}/{dateEnd}")
    public List<ScheduleResponse> getAllSchedules(@PathVariable String phoneNumber, @PathVariable LocalDate dateStart, 
            @PathVariable LocalDate dateEnd) {
        try {
            // System.out.println(dateStart + " "+ dateEnd);
            return scheduleServiceImpl.getSchedulesByUserId(phoneNumber, dateStart, dateEnd);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @GetMapping("/mark-date/{phoneNumber}")
    public List<Schedule> getMarkDate(@PathVariable String phoneNumber) {
        try {
            // System.out.println(dateStart + " "+ dateEnd);
            return scheduleServiceImpl.getMarkDate(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @PostMapping("/schedules/{phoneNumber}")
    public ResponseEntity<?> createSchedule(@PathVariable String phoneNumber ,@RequestBody SchedulesDTO schedulesDTO) {
        try {
            Items newSchedule = scheduleServiceImpl.createSchedule(phoneNumber ,schedulesDTO);
            return ResponseEntity.ok(newSchedule);
        } catch (IllegalArgumentException e) {
            System.out.println("kfds" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra, vui lòng thử lại");
        }
    }

    // Update an existing item
    @PutMapping("/schedules/{id}")
    public ResponseEntity<Items> updateSchedule(@PathVariable int id, @RequestBody SchedulesDTO schedulesDTO) {
        try {
            Items updatedSchedule = scheduleServiceImpl.updateSchedule(id, schedulesDTO);
            if (updatedSchedule != null) {
                return ResponseEntity.ok(updatedSchedule);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable int id) {
        try {
            boolean isDeleted = scheduleServiceImpl.deleteSchedule(id);
            if (isDeleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
