package com.ptit.Hirex.service.impl;

import com.ptit.Hirex.dtos.SchedulesDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.Schedule;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.ScheduleRepository;
import com.ptit.Hirex.service.ScheduleService;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ItemsRepository itemsRepository;

    @Override
    public List<Schedule> getALlSchedules() throws Exception {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule createSchedule(SchedulesDTO schedulesDTO) {
        validateScheduleDTO(schedulesDTO);
        Schedule schedule = null;
        try{
            
            schedule = scheduleRepository.findByDate(schedulesDTO.getDate());
            if (schedule == null) {
                schedule = new Schedule();
                schedule.setDate(schedulesDTO.getDate());
                schedule.setItems(new ArrayList<>());
                schedule = scheduleRepository.save(schedule);
            }
            Items item = schedulesDTO.getItems();
            validateItem(item);
            item.setSchedule(schedule);
            itemsRepository.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public Items updateSchedule(int id, SchedulesDTO schedulesDTO) throws Exception {
        Optional<Items> itemsOptional = itemsRepository.findById(id);

        if (itemsOptional.isPresent()) {
            Items item = itemsOptional.get();
            item.setStartTime(schedulesDTO.getItems().getStartTime());
            item.setEndTime(schedulesDTO.getItems().getEndTime());
            item.setTitle(schedulesDTO.getItems().getTitle());
            item.setType(schedulesDTO.getItems().getType());
            item.setNotes(schedulesDTO.getItems().getNotes());
            return itemsRepository.save(item);
        }
        else {
            throw new Exception("No item found with id: " + id);
        }
    }

    @Override
    public boolean deleteSchedule(int id) {
        try {
            itemsRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    private void validateScheduleDTO(SchedulesDTO schedulesDTO) {
        if (schedulesDTO == null || schedulesDTO.getItems() == null) {
            throw new IllegalArgumentException("Schedule data cannot be null.");
        }
    }

    private void validateItem(Items item) {
        if (StringUtils.isBlank(item.getTitle()) || StringUtils.isBlank(item.getNotes())) {
            throw new IllegalArgumentException("Item title is required.");
        }
        if(!(item.getType() == "personal" || item.getType() == "working")){
            throw new IllegalArgumentException("Type is not correct.");
        }
        if (item.getStartTime() == null || item.getEndTime() == null) {
            throw new IllegalArgumentException("Start time and end time are required.");
        }

        if (item.getStartTime().isAfter(item.getEndTime())) {
            throw new IllegalArgumentException("Start time cannot be after end time.");
        }
    }
}
