package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.responses.ScheduleResponse;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<ScheduleResponse> getSchedulesByUserId(String phoneNumber, LocalDate dateStart, LocalDate endStart) throws Exception;
    Items createSchedule(String phoneNumber, SchedulesDTO schedulesDTO) throws Exception;
    Items updateSchedule(int id,SchedulesDTO schedulesDTO) throws Exception;
    boolean deleteSchedule(int id) throws Exception;
    
    List<Schedule> getMarkDate(String phoneNumber);
}
