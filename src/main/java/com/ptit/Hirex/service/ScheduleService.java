package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedulesByUserId(String phoneNumber) throws Exception;
    Schedule createSchedule(String phoneNumber, SchedulesDTO schedulesDTO) throws Exception;
    Items updateSchedule(int id,SchedulesDTO schedulesDTO) throws Exception;
    boolean deleteSchedule(int id) throws Exception;
    
}
