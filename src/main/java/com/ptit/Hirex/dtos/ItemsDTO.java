package com.ptit.Hirex.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDTO {
    private LocalTime startTime;
    private LocalTime endTime;
    private String title;
    private String type;
    private String notes;
    private LocalDateTime notification;
    private String type_notif;
    private Integer work_id;
    private int id;
    private int totalReason;
    private List<String> nameEmployees;
}
